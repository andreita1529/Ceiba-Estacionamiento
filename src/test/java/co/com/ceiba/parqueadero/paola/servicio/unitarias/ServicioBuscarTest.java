package co.com.ceiba.parqueadero.paola.servicio.unitarias;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parquedero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ServicioBuscarTest {
	
	private ParqueaderoTestDataBuilder parqueaderoDataBuilder;
	private Parqueadero parqueadero;
	private static final Date FECHA_INGRESO = Calendar.getInstance().getTime();

	@Test
	public void createTicketMoto() {
		// arrange
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(Constantes.PLACA_MOTO)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).cilindraje("200").estado(true)
				.fechaIngreso(FECHA_INGRESO);
		// act
		this.parqueadero = this.parqueaderoDataBuilder.build();
		// assert
		assertNotNull(parqueadero);
	}

	
	@Test
	public void createTicketCarro() {
		// arrange
		this.parqueaderoDataBuilder = new ParqueaderoTestDataBuilder().placa(Constantes.PLACA_CARRO)
				.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).estado(true)
				.fechaIngreso(FECHA_INGRESO);
		// act
		this.parqueadero = this.parqueaderoDataBuilder.build();
		// assert
		assertNotNull(parqueadero);
	}

}
