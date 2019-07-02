package co.com.ceiba.parqueadero.paola.dominio.servicio;

import java.util.List;

import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;

public class BuscarVehiculoParqueaderoServicio {

private IParqueaderoRepositorio parqueaderoRepositorio;
	
	public BuscarVehiculoParqueaderoServicio(IParqueaderoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public List<Parqueadero> buscar(){
        return this.parqueaderoRepositorio.buscarRegistroVehiculos();
    }
}
