package co.com.ceiba.parqueadero.paola.dominio.servicio;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionRegistroDuplicado;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;

public class CrearVehiculoParqueaderoServicio {

	private IParqueaderoRepositorio parqueaderoRepositorio;
	
	public CrearVehiculoParqueaderoServicio(IParqueaderoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public void crear(Parqueadero parqueadero){
		validarPuesto(parqueadero);
        this.parqueaderoRepositorio.crearVehiculo(parqueadero);
    }
	
	private void validarPuesto(Parqueadero parqueadero) {
        boolean existe = parqueaderoRepositorio.existeVehiculo(parqueadero);
        if(existe) {
            throw new ExcepcionRegistroDuplicado(Constantes.VEHICULO_YA_EXISTE_EN_PARQUEADERO);
        }
    }
}
