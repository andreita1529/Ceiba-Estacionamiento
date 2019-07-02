package co.com.ceiba.parqueadero.paola.dominio.servicio;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionNoExisteVehiculo;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.modelo.ValidadorParqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;

public class ActualizarSalidaVehiculoParqueaderoServicio {

	private IParqueaderoRepositorio parqueaderoRepositorio;
	
	public ActualizarSalidaVehiculoParqueaderoServicio(IParqueaderoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public double actualizar(String placa){
		ValidadorParqueadero.validarDatoObligatorio(placa, Constantes.MENSAJE_PLACA_NULA);
		Parqueadero parqueadero = validarRegistro(placa);
		parqueadero.setEstado(false);
		parqueadero.setFechaSalida(Calendar.getInstance().getTime());
		parqueadero.setTotal(calcularPrecio(parqueadero));
        this.parqueaderoRepositorio.actualizarSalidaVehiculo(parqueadero);
        return parqueadero.getTotal();
    }
	
	private Parqueadero validarRegistro(String placa) {
		Parqueadero parqueadero = this.parqueaderoRepositorio.salida(placa);
		if (parqueadero == null) {
			throw new ExcepcionNoExisteVehiculo(Constantes.VEHICULO_NO_EXISTE_EN_PARQUEADERO);
		}
		return parqueadero;
	}
	
	private float calcularPrecio(Parqueadero parqueadero) {
		float precio = 0;
		long duracionParqueo = parqueadero.getFechaSalida().getTime() - parqueadero.getFechaIngreso().getTime();
		long minutos = TimeUnit.MILLISECONDS.toMinutes(duracionParqueo);
		duracionParqueo = TimeUnit.MILLISECONDS.toHours(duracionParqueo);
		long dias = (duracionParqueo / 24);
		long horasSobrantes = (duracionParqueo-(dias*24));
		if(minutos%60 >0) {
			horasSobrantes++;
		}
		if(horasSobrantes>=9) {
			dias ++;
			horasSobrantes=0;
		}
		if(horasSobrantes==0 && dias==0) {
			horasSobrantes=1;
		}
		if (parqueadero.getTipoVehiculo().equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO)) {
			precio += dias * Constantes.VALOR_DIA_MOTO;
			precio += horasSobrantes * Constantes.VALOR_HORA_MOTO;
			if (Integer.parseInt(parqueadero.getCilindraje()) > 500) {
				precio += Constantes.VALOR_ADICIONAL_TOPE_CILINDRAJE_MOTO;
			}
		}
		if (parqueadero.getTipoVehiculo().equalsIgnoreCase(Constantes.TIPO_VEHICULO_CARRO)) {
			precio += dias * Constantes.VALOR_DIA_CARRO;
			precio += horasSobrantes * Constantes.VALOR_DIA_CARRO;
		}
		return precio;
	}
}
