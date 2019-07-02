package co.com.ceiba.parqueadero.paola.dominio.excepcion;

public class ExcepcionNoExisteVehiculo extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionNoExisteVehiculo(String mensaje) {
        super(mensaje);
    }

}
