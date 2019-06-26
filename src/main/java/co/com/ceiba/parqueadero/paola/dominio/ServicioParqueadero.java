package co.com.ceiba.parqueadero.paola.dominio;

import java.util.List;

import co.com.ceiba.parqueadero.paola.dominio.entity.ParqueaderoEntity;

public interface ServicioParqueadero {

    public List<ParqueaderoEntity> findAll();

    public ParqueaderoEntity findById(long id);

    public ParqueaderoEntity save(ParqueaderoEntity data);	

}
