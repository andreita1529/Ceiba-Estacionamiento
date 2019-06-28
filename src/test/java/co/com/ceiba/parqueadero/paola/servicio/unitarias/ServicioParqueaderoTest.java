package co.com.ceiba.parqueadero.paola.servicio.unitarias;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.parqueadero.paola.basetest.BaseTest;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionRegistroDuplicado;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.dominio.servicio.CrearVehiculoParqueaderoServicio;
import co.com.ceiba.parquedero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ServicioParqueaderoTest {
	
	@Test
	public void validarRegistroNoExiste() {
		//Arrange
		Parqueadero parqueadero = new ParqueaderoTestDataBuilder().build();
		IParqueaderoRepositorio parqueaderoRepositorio = Mockito.mock(IParqueaderoRepositorio.class);
		Mockito.when(parqueaderoRepositorio.existeVehiculo(Mockito.any())).thenReturn(true);
		//Act
		CrearVehiculoParqueaderoServicio servicioCrearParqueadero = new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);
		//Assert
		BaseTest.assertThrows(() -> servicioCrearParqueadero.crear(parqueadero), ExcepcionRegistroDuplicado.class,"Este Vehiculo ya se encuentra dentro del parqueadero. Por favor revisar");
	}
}
