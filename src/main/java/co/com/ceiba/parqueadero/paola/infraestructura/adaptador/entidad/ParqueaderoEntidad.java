package co.com.ceiba.parqueadero.paola.infraestructura.adaptador.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "ParqueaderoEntidad")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParqueaderoEntidad {
	
	@Id
	@TableGenerator(name = "numeroRegistro", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator  = "numeroRegistro")
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

}

