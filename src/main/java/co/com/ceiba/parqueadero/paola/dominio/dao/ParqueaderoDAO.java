package co.com.ceiba.parqueadero.paola.dominio.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.parqueadero.paola.dominio.entity.ParqueaderoEntity;

public interface ParqueaderoDAO extends CrudRepository<ParqueaderoEntity, Long> {

}
