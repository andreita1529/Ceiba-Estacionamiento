package co.com.ceiba.parqueadero.paola.dominio.modelo;

import java.util.Date;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;

public class Parqueadero {
	
	private Long id;
	private String placa;
	private String tipoVehiculo;
	private int cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double total;
	
	public Parqueadero(Long id, String placa, String tipoVehiculo, int cilindraje, Date fechaIngreso, Date fechaSalida, double total) {
		ValidadorParqueadero.validarPlacaNoNula(placa);
		ValidadorParqueadero.validarTipoVehiculoNulo(tipoVehiculo);
		
		if(!tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_CARRO) && !tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO)) {
			ValidadorParqueadero.validarTipoVehiculo();
		}
		
		if(tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO)) {
			ValidadorParqueadero.validarCilindrajeObligatorio(cilindraje);
		}
		
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.total = total;
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

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
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
