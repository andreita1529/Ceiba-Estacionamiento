package co.com.ceiba.parqueadero.paola.modelo.unitarias;

import org.junit.Test;

import co.com.ceiba.parqueadero.paola.basetest.BaseTest;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionValidarPlaca;
import co.com.ceiba.parquedero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ParqueaderoTest {
	
	@Test
	public void validarPlacaObligatoria() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();
		parqueaderoTestDataBuilder.placa(null);
		//Act - Assert
		BaseTest.assertThrows(() -> parqueaderoTestDataBuilder.build(),ExcepcionValidarPlaca.class,"La placa no puede ser nula.");
	}
	
	@Test
	public void validarTipoVehiculoObligatorio() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();
		parqueaderoTestDataBuilder.tipoVehiculo(null);
		//Act - Assert
		BaseTest.assertThrows(() -> parqueaderoTestDataBuilder.build(),ExcepcionValidarPlaca.class,"El tipo de vehiculo no puede ser nulo.");
	}
	
	@Test
	public void validarTipoVehiculoDato() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();
		parqueaderoTestDataBuilder.tipoVehiculo("CARR");
		//Act - Assert
		BaseTest.assertThrows(() -> parqueaderoTestDataBuilder.build(),ExcepcionValidarPlaca.class,"El tipo de vehiculo debe ser CARRO o MOTO");
	}
	
	@Test
	public void validarCilindrajeObligatorio() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();
		parqueaderoTestDataBuilder.tipoVehiculo("MOTO");
		parqueaderoTestDataBuilder.cilindraje(0);
		//Act - Assert
		BaseTest.assertThrows(() -> parqueaderoTestDataBuilder.build(),ExcepcionValidarPlaca.class,"Si el tipo de vehiculo es moto debe ingresar el cilindraje");
	}
	
}
