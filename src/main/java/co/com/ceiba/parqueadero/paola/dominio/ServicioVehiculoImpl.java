package co.com.ceiba.parqueadero.paola.dominio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.paola.dominio.dao.VehiculoDAO;
import co.com.ceiba.parqueadero.paola.dominio.entity.VehiculoEntity;

@Service
public class ServicioVehiculoImpl implements ServicioVehiculo {

	VehiculoDAO vehiculo;

	@Override
    @Transactional(readOnly = true)
	public List<VehiculoEntity> findAll() {
		return (List<VehiculoEntity>) vehiculo.findAll();
	}

	@Override
	public VehiculoEntity findById(long id) {
		return vehiculo.findById(id).orElse(null);
	}

	@Override
	public VehiculoEntity save(VehiculoEntity datosVehiculo) {
		return vehiculo.save(datosVehiculo);
	}

}
