package co.com.ceiba.parqueadero.paola.dominio.modelo;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionCilindrajeObligatorio;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionTipoVehiculoNulo;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionValidarPlaca;

public class ValidadorParqueadero {

	private ValidadorParqueadero() {
	}
    
    public static void validarPlacaNoNula(String placa){
        if(placa == null) {
            throw new ExcepcionValidarPlaca(Constantes.MENSAJE_PLACA_NULA);
        }
    }
    
    public static void validarTipoVehiculoNulo(String tipoVehiculo) {
    	if (tipoVehiculo == null) {
            throw new ExcepcionTipoVehiculoNulo(Constantes.MENSAJE_TIPO_VEHICULO_NULO);
        }
    }
    
    public static void validarTipoVehiculo() {
        throw new ExcepcionTipoVehiculo(Constantes.MENSAJE_TIPO_VEHICULO_INCORRECTO);
    }
    
    public static void validarCilindrajeObligatorio(int cilindraje) {
        if(cilindraje == 0) {
            throw new ExcepcionCilindrajeObligatorio(Constantes.MENSAJE_CILINDRAJE_NO_NULO);
        }
    }

}
