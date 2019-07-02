package co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;

public interface IParqueaderoRepositorio {	
	
	/**
     * Se registra el vehiculo en el parqueadero
     * @param Parqueadero
     */
	public Parqueadero crearVehiculo(Parqueadero parqueadero);
	
	/**
     * Actualizar los datos de un vehiculo cuando va a salir
     * @param  Parqueadero
     */
	public boolean actualizarSalidaVehiculo(Parqueadero parqueadero);
	
	/**
     * Indica si hay cupos disponibles por tipo de vehiculo
     * @param tipoVehiculo
     * @return cantidad de vehiculos por tipo
     */
	public int cuposPorTipoVehiculo(String tipoVehiculo);
		
	/**
     * Indica si el vehiculo ya ha sido registrado
     * @param Parqueadero
     * @return existe
     */
	boolean existeVehiculo(String placa);
	
	/**
     * Lista los vehiculos registrados
     *
     * @return
     */
	List<Parqueadero> buscarRegistroVehiculos();
	
	/**
	 * Método que retorna un vehiculo del parqueadero que aun no ha salido
	 * 
	 * @param placa de vehiculo a verificar
	 * @return 
	 */
	public Parqueadero salida(String placa);
}
