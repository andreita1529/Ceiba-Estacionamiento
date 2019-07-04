package co.com.ceiba.parqueadero.paola.dominio.modelo.unitarias;

import org.junit.Test;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionObligatorio;
import co.com.ceiba.parqueadero.paola.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.paola.dominio.testbase.TestBase;
import co.com.ceiba.parqueadero.paola.testdatabuilder.ParqueaderoTestDataBuilder;

public class ParqueaderoTest {
	
	@Test
    public void validarPlacaObligatoria() {
        //Arrange
        ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();

        parqueaderoTestDataBuilder.placa(null);

        //Act - Assert
        TestBase.assertThrows(() -> parqueaderoTestDataBuilder.build(), ExcepcionObligatorio.class, Constantes.MENSAJE_PLACA_NULA);
    }

    @Test
    public void validarTipoVehiculoObligatorio() {
        //Arrange
    	ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();

    	parqueaderoTestDataBuilder.tipoVehiculo(null);

        //Act - Assert
        TestBase.assertThrows(() -> parqueaderoTestDataBuilder.build(), ExcepcionObligatorio.class, Constantes.MENSAJE_TIPO_VEHICULO_NULO);
    }

    @Test
    public void validarTipoVehiculoIncorrecto() {
        //Arrange
    	ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();
        String tipoVehiculo = "CARR";
        parqueaderoTestDataBuilder.tipoVehiculo(tipoVehiculo);

        //Act - Assert
        TestBase.assertThrows(() -> parqueaderoTestDataBuilder.build(), ExcepcionTipoVehiculo.class,Constantes.MENSAJE_TIPO_VEHICULO_INCORRECTO);
    }

    @Test
    public void validarCilindrajeObligatorio() {
        //Arrange
    	ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder();

    	parqueaderoTestDataBuilder.tipoVehiculo("MOTO");
    	parqueaderoTestDataBuilder.cilindraje(null);

        //Act - Assert
        TestBase.assertThrows(() -> parqueaderoTestDataBuilder.build(), ExcepcionObligatorio.class,Constantes.MENSAJE_CILINDRAJE_NO_NULO);
    }
}
