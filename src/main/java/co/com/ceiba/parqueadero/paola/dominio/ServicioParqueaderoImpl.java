package co.com.ceiba.parqueadero.paola.dominio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.paola.dominio.dao.ParqueaderoDAO;
import co.com.ceiba.parqueadero.paola.dominio.entity.ParqueaderoEntity;

@Service
public class ServicioParqueaderoImpl implements ServicioParqueadero{
	
	ParqueaderoDAO parqueadero;

	@Override
    @Transactional(readOnly = true)
	public List<ParqueaderoEntity> findAll() {
		return (List<ParqueaderoEntity>) parqueadero.findAll();
	}

	@Override
    @Transactional(readOnly = true)
	public ParqueaderoEntity findById(long id) {
		return parqueadero.findById(id).orElse(null);
	}

	@Override
	public ParqueaderoEntity save(ParqueaderoEntity datosParqueo) {
		return parqueadero.save(datosParqueo);
	}

}
