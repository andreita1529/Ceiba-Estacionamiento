package co.com.ceiba.parqueadero.paola.modelo.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionObligatorio;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.paola.dominio.modelo.ValidadorParqueadero;

public class ParqueaderoTest {
	
	@Test
	public void validarPlacaObligatoria() {
		
		try {
			// act
			ValidadorParqueadero.validarDatoObligatorio(Constantes.VACIO,Constantes.MENSAJE_PLACA_NULA);
			fail();
		} catch (ExcepcionObligatorio e) {
			// assert
			assertEquals(e.getMessage(), Constantes.MENSAJE_PLACA_NULA);
		}
	}
	
	@Test
	public void validarTipoVehiculoObligatorio() {
		
		try {
			// act
			ValidadorParqueadero.validarDatoObligatorio(null,Constantes.MENSAJE_TIPO_VEHICULO_NULO);
			fail();
		} catch (ExcepcionObligatorio e) {
			// assert
			assertEquals(e.getMessage(), Constantes.MENSAJE_TIPO_VEHICULO_NULO);
		}
	}
	
	@Test
	public void validarTipoVehiculoDato() {
		
		try {
			// act
			ValidadorParqueadero.validarTipoVehiculo("CARR",Constantes.MENSAJE_TIPO_VEHICULO_INCORRECTO);
			fail();
		} catch (ExcepcionTipoVehiculo e) {
			// assert
			assertEquals(e.getMessage(), Constantes.MENSAJE_TIPO_VEHICULO_INCORRECTO);
		}		
	}
}
