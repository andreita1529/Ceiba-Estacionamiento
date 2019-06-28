package co.com.ceiba.parqueadero.paola.dominio.servicio;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionNoSeActualiza;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;

public class ActualizarVehiculoParqueaderoServicio {

	private IParqueaderoRepositorio parqueaderoRepositorio;
	
	public ActualizarVehiculoParqueaderoServicio(IParqueaderoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public void actualizar(Parqueadero parqueadero){
		validarExiste(parqueadero);
        this.parqueaderoRepositorio.actualizarVehiculo(parqueadero);
    }
	
	private void validarExiste(Parqueadero parqueadero) {
        boolean existe = parqueaderoRepositorio.existeVehiculo(parqueadero);
        if(!existe) {
            throw new ExcepcionNoSeActualiza(Constantes.MENSAJE_NO_SE_PUEDE_ACTUALIZAR);
        }
    }
}
