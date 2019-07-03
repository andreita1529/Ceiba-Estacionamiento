package co.com.ceiba.parqueadero.paola.dominio.servicio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionNoExisteVehiculo;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.dominio.servicio.ActualizarSalidaVehiculoParqueaderoServicio;

public class ServicioActualizarParqueaderoTest {
	
	private static final String PLACA_CARRO = "DXR423";

	private IParqueaderoRepositorio parqueaderoRepositorio;
	private ActualizarSalidaVehiculoParqueaderoServicio servicio;

	@Before
	public void prepararDatos() {
		// arrange
		this.parqueaderoRepositorio = mock(IParqueaderoRepositorio.class);
	}
	
	@Test
	public void build() {
		// act
		this.servicio = new ActualizarSalidaVehiculoParqueaderoServicio(this.parqueaderoRepositorio);
		// assert
		assertNotNull(this.parqueaderoRepositorio);
		assertNotNull(this.servicio);
	}
	
	@Test
	public void vehiculoNoParqueado() {
		// arrange
		when(this.parqueaderoRepositorio.existeVehiculo(PLACA_CARRO)).thenReturn(false);
		this.servicio = new ActualizarSalidaVehiculoParqueaderoServicio(this.parqueaderoRepositorio);
		try {
			// act
			this.servicio.actualizar(PLACA_CARRO);
			fail();
		} catch (ExcepcionNoExisteVehiculo e) {
			// assert
			assertEquals(e.getMessage(), Constantes.VEHICULO_NO_EXISTE_EN_PARQUEADERO);
		}
	}

	@Test
	public void vehiculoParqueado() {
		// arrange
		when(this.parqueaderoRepositorio.existeVehiculo(PLACA_CARRO)).thenReturn(true);
		this.servicio = new ActualizarSalidaVehiculoParqueaderoServicio(this.parqueaderoRepositorio);
		try {
			// act
			this.servicio.actualizar(PLACA_CARRO);
		} catch (ExcepcionNoExisteVehiculo e) {
			
			// assert
			assertEquals(e.getMessage(), Constantes.VEHICULO_NO_EXISTE_EN_PARQUEADERO);
		}
	}

}
