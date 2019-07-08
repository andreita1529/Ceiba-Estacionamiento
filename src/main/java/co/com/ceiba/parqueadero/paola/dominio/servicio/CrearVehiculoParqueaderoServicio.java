package co.com.ceiba.parqueadero.paola.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.*;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.ParqueaderoRepositorio;

public class CrearVehiculoParqueaderoServicio {

	private ParqueaderoRepositorio parqueaderoRepositorio;
	
	public CrearVehiculoParqueaderoServicio(ParqueaderoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public Parqueadero crear(Parqueadero parqueadero){
		validarRegistro(parqueadero.getPlaca());
		validarCupo(parqueadero.getTipoVehiculo());
		validarEntrada(parqueadero.getPlaca(),parqueadero.getFechaIngreso());
        return this.parqueaderoRepositorio.crearVehiculo(parqueadero);
    }
	
	private void validarRegistro(String placa) {
        boolean existe = parqueaderoRepositorio.existeVehiculo(placa);
        if(existe) {
            throw new ExcepcionRegistroDuplicado(Constantes.VEHICULO_YA_EXISTE_EN_PARQUEADERO);
        }
    }
	
	private void validarCupo(String tipoVehiculo) {
		if(tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO) && 
		   parqueaderoRepositorio.cuposPorTipoVehiculo(tipoVehiculo) == Constantes.CANTIDAD_MAXIMA_MOTOS) {
			throw new ExcepcionNoCupo(Constantes.MENSAJE_SOBRECUPO);
		}
		if(tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_CARRO) && 
		   parqueaderoRepositorio.cuposPorTipoVehiculo(tipoVehiculo) == Constantes.CANTIDAD_MAXIMA_CARROS) {
			throw new ExcepcionNoCupo(Constantes.MENSAJE_SOBRECUPO);
		}
    }
	
	private void validarEntrada(String placa, Date fechaIngreso) {
		Calendar fechaActual = Calendar.getInstance();
		fechaActual.setTimeInMillis(fechaIngreso.getTime());
		int day = fechaActual.get(Calendar.DAY_OF_WEEK);
		if (placa.startsWith(Constantes.LETRA_INICIO_PLACA) || placa.startsWith("a") && (day != Calendar.MONDAY || day != Calendar.SUNDAY)) {
			throw new ExcepcionLetraPlaca(Constantes.MENSAJE_ACCESO_NO_AUTORIZADO_PLACA);
		}
    }
}
