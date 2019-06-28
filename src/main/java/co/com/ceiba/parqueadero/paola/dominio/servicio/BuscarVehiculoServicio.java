package co.com.ceiba.parqueadero.paola.dominio.servicio;

import java.util.List;

import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;

public class BuscarVehiculoServicio {

private IParqueaderoRepositorio parqueaderoRepositorio;
	
	public BuscarVehiculoServicio(IParqueaderoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public List<Parqueadero> buscar(){
        return this.parqueaderoRepositorio.buscarRegistroVehiculos();
    }
}
