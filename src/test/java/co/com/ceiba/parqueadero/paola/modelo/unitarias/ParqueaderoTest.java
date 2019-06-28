package co.com.ceiba.parqueadero.paola.modelo.unitarias;

import org.junit.Test;

import co.com.ceiba.parqueadero.paola.basetest.BaseTest;
import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.*;
import co.com.ceiba.parquedero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ParqueaderoTest {
	
	@Test
	public void validarPlacaObligatoria() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();
		parqueaderoTestDataBuilder.placa(null);
		//Act - Assert
		BaseTest.assertThrows(() -> parqueaderoTestDataBuilder.build(),ExcepcionValidarPlaca.class,Constantes.MENSAJE_PLACA_NULA);
	}
	
	@Test
	public void validarTipoVehiculoObligatorio() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();
		parqueaderoTestDataBuilder.tipoVehiculo(null);
		//Act - Assert
		BaseTest.assertThrows(() -> parqueaderoTestDataBuilder.build(),ExcepcionTipoVehiculoNulo.class,Constantes.MENSAJE_TIPO_VEHICULO_NULO);
	}
	
	@Test
	public void validarTipoVehiculoDato() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();
		parqueaderoTestDataBuilder.tipoVehiculo("CARR");
		//Act - Assert
		BaseTest.assertThrows(() -> parqueaderoTestDataBuilder.build(),ExcepcionTipoVehiculo.class,Constantes.MENSAJE_TIPO_VEHICULO_INCORRECTO);
	}
	
	@Test
	public void validarCilindrajeObligatorio() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();
		parqueaderoTestDataBuilder.placa("HIL01E");
		parqueaderoTestDataBuilder.tipoVehiculo("MOTO");
		parqueaderoTestDataBuilder.cilindraje(0);
		//Act - Assert
		BaseTest.assertThrows(() -> parqueaderoTestDataBuilder.build(),ExcepcionCilindrajeObligatorio.class,Constantes.MENSAJE_CILINDRAJE_NO_NULO);
	}
	
}
