package co.com.ceiba.parqueadero.paola.dominio.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.parqueadero.paola.dominio.entity.VehiculoEntity;

public interface VehiculoDAO extends CrudRepository<VehiculoEntity, Long>{

}
