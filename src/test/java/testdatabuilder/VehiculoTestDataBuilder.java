package testdatabuilder;

import co.com.ceiba.parqueadero.paola.dominio.entity.VehiculoEntity;

public class VehiculoTestDataBuilder {

	private static final String PLACA= "DXR423";
	private static final String TIPOVEHICULO = "CARRO";
	private static final int CILINDRAJE = 0;
	
	private String placa;
	private String tipoVehiculo;
	private int cilindraje;
	
	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.tipoVehiculo = TIPOVEHICULO;
		this.cilindraje = CILINDRAJE;
		
	}

	public VehiculoTestDataBuilder placa(String placa) {
		this.placa=placa;
		return this;
	}

	public VehiculoTestDataBuilder tipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo=tipoVehiculo;
		return this;
	}

	public VehiculoTestDataBuilder cilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	
	public VehiculoEntity build() {
		return new VehiculoEntity(this.placa, this.tipoVehiculo, this.cilindraje);
	}
}
