package co.com.ceiba.parqueadero.paola.dominio.modelo;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionObligatorio;

public class ValidadorParqueadero {

	private ValidadorParqueadero() {
	}
    
    public static void validarDatoObligatorio(Object dato, String mensaje){
        if(dato == null || dato.equals(Constantes.VACIO)) {
            throw new ExcepcionObligatorio(mensaje);
        }
    }
    
    public static void validarTipoVehiculo(String mensaje) {
        throw new ExcepcionTipoVehiculo(mensaje);
    }

}
