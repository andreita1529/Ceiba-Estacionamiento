package co.com.ceiba.parquedero.paola.testdatabuilder;

import java.util.Date;

import co.com.ceiba.parqueadero.paola.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;

public class ParqueaderoTestDataBuilder {
	
	private Long id;
	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double total;
	
	
    public ParqueaderoTestDataBuilder(){
        this.id = 1L;
        this.tipoVehiculo = Constantes.TIPO_VEHICULO_CARRO;
        this.placa = "DXR423";
        this.cilindraje = "0";
        this.fechaIngreso = null;
        this.fechaSalida = null;
        this.total = 0;
    }
	
	public ParqueaderoTestDataBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ParqueaderoTestDataBuilder tipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public ParqueaderoTestDataBuilder placa(String placa) {
        this.placa = placa;
        return this;
    }

    public ParqueaderoTestDataBuilder cilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public ParqueaderoTestDataBuilder fechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public ParqueaderoTestDataBuilder fechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }
    public ParqueaderoTestDataBuilder total(long total) {
        this.total = total;
        return this;
    }

    public Parqueadero build(){
    	Parqueadero parqueadero = new Parqueadero();
    	parqueadero.setId(this.id);
    	parqueadero.setPlaca(this.placa);
    	parqueadero.setTipoVehiculo(this.tipoVehiculo);
    	parqueadero.setCilindraje(this.cilindraje);
    	parqueadero.setFechaIngreso(this.fechaIngreso);
    	parqueadero.setFechaSalida(this.fechaSalida);
    	parqueadero.setTotal(this.total);
        return parqueadero;
    }
}
