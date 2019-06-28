package co.com.ceiba.parqueadero.paola.servicio.unitarias;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.parqueadero.paola.basetest.BaseTest;
import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.*;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.dominio.servicio.*;
import co.com.ceiba.parquedero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ServicioParqueaderoTest {
	
	@Test
	public void validarVehiculoNoExiste() {
		//Arrange
		Parqueadero parqueadero = new ParqueaderoTestDataBuilder().build();
		IParqueaderoRepositorio parqueaderoRepositorio = Mockito.mock(IParqueaderoRepositorio.class);
		Mockito.when(parqueaderoRepositorio.existeVehiculo(Mockito.any())).thenReturn(true);
		//Act
		CrearVehiculoParqueaderoServicio servicioCrearParqueadero = new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);
		//Assert
		BaseTest.assertThrows(() -> servicioCrearParqueadero.crear(parqueadero), ExcepcionRegistroDuplicado.class,Constantes.VEHICULO_YA_EXISTE_EN_PARQUEADERO);
	}
	
	@Test
	public void validarExisteActualizar() {
		//Arrange
		Parqueadero parqueadero = new ParqueaderoTestDataBuilder().build();
		IParqueaderoRepositorio parqueaderoRepositorio = Mockito.mock(IParqueaderoRepositorio.class);
		Mockito.when(parqueaderoRepositorio.existeVehiculo(Mockito.any())).thenReturn(false);
		//Act
		ActualizarVehiculoParqueaderoServicio servicioCrearParqueadero = new ActualizarVehiculoParqueaderoServicio(parqueaderoRepositorio);
		//Assert
		BaseTest.assertThrows(() -> servicioCrearParqueadero.actualizar(parqueadero), ExcepcionNoSeActualiza.class,Constantes.MENSAJE_NO_SE_PUEDE_ACTUALIZAR);
	}
	
}
