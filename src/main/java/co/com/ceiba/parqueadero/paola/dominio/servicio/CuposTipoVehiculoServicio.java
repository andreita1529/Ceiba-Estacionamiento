package co.com.ceiba.parqueadero.paola.dominio.servicio;

import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;

public class CuposTipoVehiculoServicio {
	
	private IParqueaderoRepositorio parqueaderoRepositorio;
	
	public CuposTipoVehiculoServicio(IParqueaderoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public int contar(String tipoVehiculo){
        return this.parqueaderoRepositorio.cuposPorTipoVehiculo(tipoVehiculo);
    }
}
