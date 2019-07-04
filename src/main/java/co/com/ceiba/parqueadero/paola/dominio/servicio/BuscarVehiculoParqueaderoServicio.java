package co.com.ceiba.parqueadero.paola.dominio.servicio;

import java.util.List;

import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.ParqueaderoRepositorio;

public class BuscarVehiculoParqueaderoServicio {

private ParqueaderoRepositorio parqueaderoRepositorio;
	
	public BuscarVehiculoParqueaderoServicio(ParqueaderoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public List<Parqueadero> buscar(){
        return this.parqueaderoRepositorio.buscarRegistroVehiculos();
    }
}
