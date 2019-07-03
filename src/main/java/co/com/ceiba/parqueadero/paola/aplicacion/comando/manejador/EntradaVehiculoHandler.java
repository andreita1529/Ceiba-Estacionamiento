package co.com.ceiba.parqueadero.paola.aplicacion.comando.manejador;

import java.util.Date;

import co.com.ceiba.parqueadero.paola.aplicacion.comando.ParqueaderoComando;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.servicio.CrearVehiculoParqueaderoServicio;

public class EntradaVehiculoHandler {
	
	private final CrearVehiculoParqueaderoServicio crearServicio;

    public EntradaVehiculoHandler(CrearVehiculoParqueaderoServicio servicio){
        this.crearServicio = servicio;
    }

    public  void crear(ParqueaderoComando parqueaderoComando){
        this.crearServicio.crear(new Parqueadero(parqueaderoComando.getId(), 
        										 parqueaderoComando.getPlaca(),parqueaderoComando.getTipoVehiculo(),parqueaderoComando.getCilindraje(),
        										 new Date(),parqueaderoComando.getFechaSalida(),
        										 parqueaderoComando.getTotal()));
    }

}
