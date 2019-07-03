package co.com.ceiba.parqueadero.paola.infraestructura.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity(name = "ParqueaderoEntidad")
public class ParqueaderoEntidad {
	
	public ParqueaderoEntidad() {
		
	};
	
	public ParqueaderoEntidad(Long id, String placa, String tipoVehiculo, String cilindraje, Date fechaIngreso, Date fechaSalida, double valorTotal) {
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.valorTotal = valorTotal;
	}

	@Id
	@TableGenerator(name = "numeroRegistro", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String placa;
	
	@Column(nullable = false)
	private String tipoVehiculo;

	@Column
	private String cilindraje;
	
	@Column(nullable = false)
	private Date fechaIngreso;
	
	@Column
	private Date fechaSalida;
	
	@Column
	private double valorTotal;

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

	public Date getFechasalida() {
		return fechaSalida;
	}

	public void setFechasalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

		
}
