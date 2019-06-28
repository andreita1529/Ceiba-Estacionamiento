package co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;

public interface IParqueaderoRepositorio {	
	
	/**
     * Se registra el vehiculo en el parqueadero
     * @param Parqueadero
     */
	void crearVehiculo(Parqueadero parqueadero);
	
	/**
     * Actualizar los datos de un vehiculo
     * @param  Parqueadero
     */
	void actualizarVehiculo(Parqueadero parqueadero);
	
	/**
     * Indica si hay cupos disponibles por tipo de vehiculo
     * @param tipoVehiculo
     * @return cantidad de vehiculos por tipo
     */
	int cuposPorTipoVehiculo(String tipoVehiculo);
		
	/**
     * Indica si el vehiculo ya ha sido registrado
     * @param Parqueadero
     * @return existe
     */
	boolean existeVehiculo(Parqueadero parqueadero);
	
	/**
     * Lista los vehiculos registrados
     *
     * @return
     */
	List<Parqueadero> buscarRegistroVehiculos();
}
