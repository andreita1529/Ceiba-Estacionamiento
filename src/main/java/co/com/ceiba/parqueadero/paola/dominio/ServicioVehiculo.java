package co.com.ceiba.parqueadero.paola.dominio;

import java.util.List;

import co.com.ceiba.parqueadero.paola.dominio.entity.VehiculoEntity;

public interface ServicioVehiculo {

	public List<VehiculoEntity> findAll();

    public VehiculoEntity findById(long id);

    public VehiculoEntity save(VehiculoEntity data);	
}
