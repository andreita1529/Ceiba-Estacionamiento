package co.com.ceiba.parqueadero.paola.dominio.modelo;

import java.util.Date;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parqueadero {
	
	private Long id;
	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double total;
	
	public Parqueadero(Long id, String placa, String tipoVehiculo, String cilindraje, Date fechaIngreso, Date fechaSalida, double total) {
		ValidadorParqueadero.validarDatoObligatorio(placa, Constantes.MENSAJE_PLACA_NULA);
		ValidadorParqueadero.validarDatoObligatorio(tipoVehiculo, Constantes.MENSAJE_TIPO_VEHICULO_NULO);
		
		ValidadorParqueadero.validarTipoVehiculo(tipoVehiculo, Constantes.MENSAJE_TIPO_VEHICULO_INCORRECTO);
		
		if(tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO)) {
			ValidadorParqueadero.validarDatoObligatorio(cilindraje, Constantes.MENSAJE_CILINDRAJE_NO_NULO);
		}
		
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.total = total;
	}
}
