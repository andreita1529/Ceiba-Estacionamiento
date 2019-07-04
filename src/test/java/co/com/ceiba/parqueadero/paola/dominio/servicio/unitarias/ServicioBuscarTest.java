package co.com.ceiba.parqueadero.paola.dominio.servicio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.ParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.dominio.servicio.BuscarVehiculoParqueaderoServicio;
import co.com.ceiba.parqueadero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ServicioBuscarTest {
	
	private ParqueaderoRepositorio parqueaderoRepositorio;

	@Before
	public void prepararDatos() {
		// arrange
		this.parqueaderoRepositorio = mock(ParqueaderoRepositorio.class);
	}

	@Test
	public void listarParqueadero() {
		//Arrange
        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
        
        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        BuscarVehiculoParqueaderoServicio listarServicio = new BuscarVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(parqueadero);
        
        List<Parqueadero> listaParqeuadero = listarServicio.buscar();
        assertNotNull(listaParqeuadero);
	}
	
	@Test
	public void listarParqueaderoVacio() {
		
		List<Parqueadero> vacio = new ArrayList<>();
		//Arrange
        ParqueaderoTestDataBuilder parqueaderoDataBuilder = new ParqueaderoTestDataBuilder()
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
        
        Parqueadero parqueadero = parqueaderoDataBuilder.build();

        BuscarVehiculoParqueaderoServicio listarServicio = new BuscarVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(null);
        
        List<Parqueadero> listaParqeuadero = listarServicio.buscar();
        assertEquals(vacio,listaParqeuadero);
	}


}
