package co.com.ceiba.parqueadero.paola.dominio.modelo;

import java.util.Date;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;

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
	
	public Parqueadero() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
