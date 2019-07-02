package co.com.ceiba.parqueadero.paola.servicio.unitarias;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionNoCupo;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionNoExisteVehiculo;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionRegistroDuplicado;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.dominio.servicio.CrearVehiculoParqueaderoServicio;
import co.com.ceiba.parquedero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ServicioCrearParqueaderoTest {
	
	private static final String PLACA_CARRO = "DXR423";
	private static final String PLACA_MOTO = "HIL01E";
	private static final String CILINDRAJE = "200";
	
	private IParqueaderoRepositorio parqueaderoRepositorio;
	private CrearVehiculoParqueaderoServicio servicio;
	private ParqueaderoTestDataBuilder parqueaderoDataBuilder;
	private Parqueadero parqueadero;
	private Date hoy;

	@Before
	public void prepararDatos() {
		// arrange
		this.parqueaderoRepositorio = mock(IParqueaderoRepositorio.class);
		this.hoy = Calendar.getInstance().getTime();
	}
	
	@Test
	public void build() {
		// act
		this.servicio = new CrearVehiculoParqueaderoServicio(this.parqueaderoRepositorio);
		// assert
		assertNotNull(this.parqueaderoRepositorio);
		assertNotNull(this.servicio);
	}
	
	@Test
	public void crearParqueoMoto() {
		// arrange
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(PLACA_MOTO).cilindraje(CILINDRAJE)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).fechaIngreso(hoy);
		this.parqueadero = this.parqueaderoDataBuilder.build();
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(PLACA_MOTO).cilindraje(CILINDRAJE)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).fechaIngreso(hoy).total(0);
		Parqueadero parqueaderoEntrada = this.parqueaderoDataBuilder.build();
		when(this.parqueaderoRepositorio.crearVehiculo(this.parqueadero)).thenReturn(parqueaderoEntrada);
		this.servicio = new CrearVehiculoParqueaderoServicio(this.parqueaderoRepositorio);
		// act
		Parqueadero parqueo = this.servicio.crear(this.parqueadero);
		// assert
		assertEquals(parqueo, parqueaderoEntrada);
	}
	
	@Test
	public void crearParqueoCarro() {
		// arrange
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(PLACA_CARRO)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).fechaIngreso(hoy);
		this.parqueadero = this.parqueaderoDataBuilder.build();
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(PLACA_CARRO)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).fechaIngreso(hoy).total(0);
		Parqueadero parqueaderoEntrada = this.parqueaderoDataBuilder.build();
		when(this.parqueaderoRepositorio.crearVehiculo(this.parqueadero)).thenReturn(parqueaderoEntrada);
		this.servicio = new CrearVehiculoParqueaderoServicio(this.parqueaderoRepositorio);
		// act
		Parqueadero parqueo = this.servicio.crear(this.parqueadero);
		// assert
		assertEquals(parqueo, parqueaderoEntrada);
	}
	
	@Test
	public void vehiculoParqueado() {
		// arrange
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(PLACA_CARRO)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).fechaIngreso(hoy);
		this.parqueadero = this.parqueaderoDataBuilder.build();
		when(this.parqueaderoRepositorio.existeVehiculo(PLACA_CARRO)).thenReturn(true);
		this.servicio = new CrearVehiculoParqueaderoServicio(this.parqueaderoRepositorio);
		try {
			// act
			this.servicio.crear(this.parqueadero);
		} catch (ExcepcionRegistroDuplicado e) {
			// assert
			assertEquals(e.getMessage(), Constantes.VEHICULO_YA_EXISTE_EN_PARQUEADERO);
		}
	}
	
	@Test
	public void vehiculoNoParqueado() {
		// arrange
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(PLACA_CARRO)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).fechaIngreso(hoy);
		this.parqueadero = this.parqueaderoDataBuilder.build();
		when(this.parqueaderoRepositorio.existeVehiculo(PLACA_CARRO)).thenReturn(false);
		this.servicio = new CrearVehiculoParqueaderoServicio(this.parqueaderoRepositorio);
		try {
			// act
			this.servicio.crear(this.parqueadero);
		} catch (ExcepcionNoExisteVehiculo e) {
			// assert
			assertEquals(e.getMessage(), Constantes.VEHICULO_NO_EXISTE_EN_PARQUEADERO);
		}
	}
	
	@Test
	public void validarExiste() {
		// arrange
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(PLACA_CARRO)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
		this.parqueadero = this.parqueaderoDataBuilder.build();
		when(this.parqueaderoRepositorio.existeVehiculo(PLACA_CARRO)).thenReturn(true);
		// assert
		assertEquals(this.parqueaderoRepositorio.existeVehiculo(PLACA_CARRO), true);
		
	}
	
	@Test
	public void validarNoExiste() {
		// arrange
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(PLACA_CARRO)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
		this.parqueadero = this.parqueaderoDataBuilder.build();
		when(this.parqueaderoRepositorio.existeVehiculo(PLACA_CARRO)).thenReturn(false);
		// assert
		assertEquals(this.parqueaderoRepositorio.existeVehiculo(PLACA_CARRO), false);
		
	}
	
	@Test
	public void validarCupoMoto() {
		// arrange
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(PLACA_MOTO).cilindraje(CILINDRAJE)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).fechaIngreso(hoy);
		this.parqueadero = this.parqueaderoDataBuilder.build();
		when(this.parqueaderoRepositorio.cuposPorTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)).thenReturn(Constantes.CANTIDAD_MAXIMA_MOTOS);
		this.servicio = new CrearVehiculoParqueaderoServicio(this.parqueaderoRepositorio);
		try {
			// act
			this.servicio.crear(this.parqueadero);
			fail();
		} catch (ExcepcionNoCupo e) {
			// assert
			assertEquals(e.getMessage(), Constantes.MENSAJE_SOBRECUPO);
		}
	}
	
	@Test
	public void validarCupoCarro() {
		// arrange
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(PLACA_CARRO)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).fechaIngreso(hoy);
		this.parqueadero = this.parqueaderoDataBuilder.build();
		when(this.parqueaderoRepositorio.cuposPorTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(Constantes.CANTIDAD_MAXIMA_CARROS);
		this.servicio = new CrearVehiculoParqueaderoServicio(this.parqueaderoRepositorio);
		try {
			// act
			this.servicio.crear(this.parqueadero);
			fail();
		} catch (ExcepcionNoCupo e) {
			// assert
			assertEquals(e.getMessage(), Constantes.MENSAJE_SOBRECUPO);
		}
	}

}
