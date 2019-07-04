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
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.ParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.dominio.servicio.ActualizarSalidaVehiculoParqueaderoServicio;
import co.com.ceiba.parqueadero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ServicioActualizarParqueaderoTest {

	private ParqueaderoRepositorio parqueaderoRepositorio;

	@Before
	public void prepararDatos() {
		// arrange
		this.parqueaderoRepositorio = mock(ParqueaderoRepositorio.class);
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
        double valorPorHora = 500;
        int hora = 7;
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

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
        assertEquals((valorPorHora * hora), parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarHoraCarro() {
        //Arrange
        double valorPorHora = 1000;
        int hora = 7;
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
                .fechaIngreso(fecha.getTime());

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valorPorHora * hora),parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarAdicionalMoto() {
        //Arrange
        double valorPorHora = 500;
        int hora = 7;
        int valorAdicional = 2000;

        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

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
        assertEquals((valorPorHora * hora)+valorAdicional,parqueadero.getTotal(),0);
    }
	
	@Test
    public void  validarDiaCarro() {
        //Arrange
        double valorDia = 8000;
        int hora = 9;
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
        		.fechaIngreso(fecha.getTime());

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals(valorDia,parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarDiaMotoCilindraje() {
        //Arrange
        double valorDia = 4000;
        int hora = 9;
        int valorAdicional = 2000;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

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
        assertEquals(valorDia + valorAdicional,parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarDiaMoto() {
        //Arrange
        double valorDia = 4000;
        int hora = 9;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

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
        assertEquals(valorDia ,parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarDiasCarro() {
        //Arrange
        double valorDia = 8000;
        double valorHora = 1000;
        int hora = 26;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
        		.fechaIngreso(fecha.getTime());

        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valorHora*2) + valorDia,parqueadero.getTotal(),0);

    }
	
	@Test
    public void  validarDiasMoto() {
        //Arrange
        double valorDia = 4000;
        double valorHora = 500;
        int hora = 26;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

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
        assertEquals((valorHora*2)+valorDia,parqueadero.getTotal(),0);

    }

}
