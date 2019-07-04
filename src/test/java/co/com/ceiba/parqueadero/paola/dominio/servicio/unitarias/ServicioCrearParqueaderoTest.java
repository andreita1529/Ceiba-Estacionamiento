package co.com.ceiba.parqueadero.paola.dominio.servicio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionLetraPlaca;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionNoCupo;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionRegistroDuplicado;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.dominio.servicio.CrearVehiculoParqueaderoServicio;
import co.com.ceiba.parqueadero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ServicioCrearParqueaderoTest {
	
	private IParqueaderoRepositorio parqueaderoRepositorio;

	@Before
	public void prepararDatos() {
		// arrange
		this.parqueaderoRepositorio = mock(IParqueaderoRepositorio.class);
	}
	
	@Test
	public void crearParqueoMoto() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
				.placa(Constantes.PLACA_MOTO)
                .tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
                .cilindraje("600");

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        CrearVehiculoParqueaderoServicio crearServicio = new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);

        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(parqueadero);

        //Act
        Parqueadero parqueaderoCopia =  crearServicio.crear(parqueadero);

        //Assert
        assertEquals(parqueaderoCopia.getId(),parqueadero.getId());
	}
	
	@Test
	public void crearParqueoCarro() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
				.placa(Constantes.PLACA_CARRO)
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        CrearVehiculoParqueaderoServicio crearServicio = new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);

        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(parqueadero);

        //Act
        Parqueadero parqueaderoCopia =  crearServicio.crear(parqueadero);

        //Assert
        assertEquals(parqueaderoCopia.getId(),parqueadero.getId());
	}
	
	@Test
	public void validarCupoMoto() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
				.placa(Constantes.PLACA_MOTO)
                .tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
                .cilindraje("600");

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        CrearVehiculoParqueaderoServicio crearServicio = new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);

        when(parqueaderoRepositorio.cuposPorTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)).thenReturn(Constantes.CANTIDAD_MAXIMA_MOTOS);

        //Act
        try {
        	crearServicio.crear(parqueadero);
            fail();
        }catch (ExcepcionNoCupo e){
            // Assert
            assertEquals(Constantes.MENSAJE_SOBRECUPO, e.getMessage());
        }
	}
	
	@Test
	public void validarCupoCarro() {
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
				.placa(Constantes.PLACA_CARRO)
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        CrearVehiculoParqueaderoServicio crearServicio = new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);

        when(parqueaderoRepositorio.cuposPorTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(Constantes.CANTIDAD_MAXIMA_CARROS);

        //Act
        try {
        	crearServicio.crear(parqueadero);
            fail();
        }catch (ExcepcionNoCupo e){
            // Assert
            assertEquals(Constantes.MENSAJE_SOBRECUPO, e.getMessage());
        }
	}
	
	@Test
    public void validarRestriccionLetraPlaca(){
        //Arrange
        Calendar fechaIngreso = Calendar.getInstance();
        fechaIngreso.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa("ADF123")
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).fechaIngreso(fechaIngreso.getTime());
        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        CrearVehiculoParqueaderoServicio crearServicio = new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);
        //Act

        try {
        	crearServicio.crear(parqueadero);
            fail();
        }catch (ExcepcionLetraPlaca e){
            // Assert
            assertEquals(Constantes.MENSAJE_ACCESO_NO_AUTORIZADO_PLACA, e.getMessage());
        }
    }
	
	@Test
    public void validarExisteCarro(){
        //Arrange
        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        CrearVehiculoParqueaderoServicio crearServicio = new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(parqueadero);
        //Act

        try {
        	crearServicio.crear(parqueadero);
        }catch (ExcepcionRegistroDuplicado e){
            // Assert
            assertEquals(Constantes.VEHICULO_YA_EXISTE_EN_PARQUEADERO, e.getMessage());
        }
    }

}
