package co.com.ceiba.parqueadero.paola.dominio.modelo;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionObligatorio;

public final class ValidadorParqueadero {

	private ValidadorParqueadero() {
	}
    
    public static void validarDatoObligatorio(Object dato, String mensaje){
        if(dato == null || dato.equals(Constantes.VACIO)) {
            throw new ExcepcionObligatorio(mensaje);
        }
    }
    
    public static void validarTipoVehiculo(Object dato, String mensaje) {
	    if(!dato.equals(Constantes.TIPO_VEHICULO_CARRO) && !dato.equals(Constantes.TIPO_VEHICULO_MOTO)) {
	        throw new ExcepcionTipoVehiculo(mensaje);
	    }
    }

}
