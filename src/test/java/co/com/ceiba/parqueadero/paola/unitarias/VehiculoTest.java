package co.com.ceiba.parqueadero.paola.unitarias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.parqueadero.paola.dominio.entity.VehiculoEntity;
import testdatabuilder.VehiculoTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehiculoTest {
	
	private static final String PLACA = "HIL325";
	private static final String TIPO_VEHICULO = "CARRO";
	private static final int CILINDRAJE = 0;

	@Test
	public void crearVehiculoTest() {
		
		// arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().
				placa(PLACA).
				tipoVehiculo(TIPO_VEHICULO).
				cilindraje(CILINDRAJE);

		// act
		VehiculoEntity vehiculo = vehiculoTestDataBuilder.build();

		// assert
		assertEquals(PLACA, vehiculo.getPlaca());
		assertEquals(TIPO_VEHICULO, vehiculo.getTipoVehiculo());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje(),0);
	}


}
