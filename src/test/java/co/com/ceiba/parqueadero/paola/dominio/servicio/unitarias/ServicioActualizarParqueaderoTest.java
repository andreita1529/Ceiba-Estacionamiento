package co.com.ceiba.parqueadero.paola.dominio.servicio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionNoExisteVehiculo;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.dominio.servicio.ActualizarSalidaVehiculoParqueaderoServicio;
import co.com.ceiba.parqueadero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ServicioActualizarParqueaderoTest {

	private IParqueaderoRepositorio parqueaderoRepositorio;

	@Before
	public void prepararDatos() {
		// arrange
		this.parqueaderoRepositorio = mock(IParqueaderoRepositorio.class);
	}
	
	@Test
	public void vehiculoNoParqueado() {
		
		//Arrange
		ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
				.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);

        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(null);

        //Act

        try {
        	salidaServicio.actualizar(parqueadero.getPlaca());
            fail();
        }catch (ExcepcionNoExisteVehiculo e){
            // Assert
            assertEquals(Constantes.VEHICULO_NO_EXISTE_EN_PARQUEADERO, e.getMessage());
        }
	}

	@Test
    public void  validarHoraMoto() {
        //Arrange
        double valueForHour = 500;
        int hour = 7;
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hour);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
                .tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
                .fechaIngreso(fecha.getTime())
                .cilindraje("200");

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valueForHour * hour), parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarHoraCarro() {
        //Arrange
        double valueForHour = 1000;
        int hour = 7;
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hour);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
                .fechaIngreso(fecha.getTime());

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valueForHour * hour),parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarAdicionalMoto() {
        //Arrange
        double valueForHour = 500;
        int hour = 7;
        int valueAdictional = 2000;

        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hour);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
                .fechaIngreso(fecha.getTime())
                .cilindraje("600");

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valueForHour * hour)+valueAdictional,parqueadero.getTotal(),0);
    }
	
	@Test
    public void  validarDiaCarro() {
        //Arrange
        double valueDay = 8000;
        int hour = 9;
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hour);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
        		.fechaIngreso(fecha.getTime());

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals(valueDay,parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarDiaMotoCilindraje() {
        //Arrange
        double valueDay = 4000;
        int hour = 9;
        int valueAdictional = 2000;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hour);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
        		.cilindraje("650")
        		.fechaIngreso(fecha.getTime());

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals(valueDay + valueAdictional,parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarDiaMoto() {
        //Arrange
        double valueDay = 4000;
        int hour = 9;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hour);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
        		.cilindraje("200")
        		.fechaIngreso(fecha.getTime());

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals(valueDay ,parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarDiasCarro() {
        //Arrange
        double valueDay = 8000;
        double valueHour = 1000;
        int hour = 26;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hour);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
        		.fechaIngreso(fecha.getTime());

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valueHour*2) + valueDay,parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarDiasMoto() {
        //Arrange
        double valueDay = 4000;
        double valueHour = 500;
        int hour = 26;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hour);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
        		.cilindraje("200")
        		.fechaIngreso(fecha.getTime());

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valueHour*2)+valueDay,parqueadero.getTotal(),0);

    }

}
