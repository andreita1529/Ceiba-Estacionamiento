package co.com.ceiba.parqueadero.paola.dominio.servicio;

import java.util.Calendar;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionNoExisteVehiculo;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.modelo.ValidadorParqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.ParqueaderoRepositorio;

public class ActualizarSalidaVehiculoParqueaderoServicio {

	private ParqueaderoRepositorio parqueaderoRepositorio;
	
	public ActualizarSalidaVehiculoParqueaderoServicio(ParqueaderoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public double actualizar(String placa){
		ValidadorParqueadero.validarDatoObligatorio(placa, Constantes.MENSAJE_PLACA_NULA);
		Parqueadero parqueadero = validarRegistro(placa);
		parqueadero.setFechaSalida(Calendar.getInstance().getTime());
		if(parqueadero.getTipoVehiculo().equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO)) {
			calcularPrecioMoto(parqueadero);
		}else{
			calcularPrecioCarro(parqueadero);
		}
		
        this.parqueaderoRepositorio.crearVehiculo(parqueadero);
        return parqueadero.getTotal();
    }
	
	private Parqueadero validarRegistro(String placa) {
		Parqueadero parqueadero = this.parqueaderoRepositorio.buscarPorPlaca(placa);
		if (parqueadero == null) {
			throw new ExcepcionNoExisteVehiculo(Constantes.VEHICULO_NO_EXISTE_EN_PARQUEADERO);
		}
		return parqueadero;
	}
	
	public void calcularPrecioMoto(Parqueadero registry) {
        long value;
        double milisegund = (registry.getFechaSalida().getTime() - registry.getFechaIngreso().getTime());
        double hour = (milisegund/3600000);
        double minute = (milisegund/60000);
        long totalHour = Math.round(hour);
        long totalMinute = Math.round(minute);
        int totalDay = (int)  totalHour / 24;
        int  totalHourNewDay = (int) totalHour % 24;


        if(totalHour < 9){
            if((totalMinute >= 10) && (totalHour == 0)){
                value = 500;
            }else{
                value = totalHour * 500;
            }
        }else if(totalHourNewDay == 0 || (totalHourNewDay >= 9 && totalHourNewDay < 24)){
            value = (4000 * (totalDay == 0 ? 1:totalDay));
        }else{
            value = ((4000 * totalDay) + (totalHourNewDay * 500));
        }
        
        if(Integer.valueOf(registry.getCilindraje()) > 500 ){
            value = value + 2000;
        }
        
        registry.setTotal(value);
    }
	
	public void calcularPrecioCarro(Parqueadero registry) {
        long value;
        double milisegund = (registry.getFechaSalida().getTime() - registry.getFechaIngreso().getTime());
        double hour = (milisegund/3600000);
        double minute = (milisegund/60000);
        long totalHour = Math.round(hour);
        long totalMinute = Math.round(minute);
        int totalDay = (int)  totalHour / 24;
        int  totalHourNewDay = (int) totalHour % 24;


        if(totalHour < 9){
            if((totalMinute >= 10) && (totalHour == 0)){
                value = 1000;
            }else{
                value = totalHour * 1000;
            }
        }else if(totalHourNewDay == 0 || (totalHourNewDay >= 9 && totalHourNewDay < 24)){
            value = (8000 * (totalDay == 0 ? 1:totalDay));
        }else{
            value = ((8000 * totalDay) + (totalHourNewDay * 1000));
        }
        
        registry.setTotal(value);
    }
}
