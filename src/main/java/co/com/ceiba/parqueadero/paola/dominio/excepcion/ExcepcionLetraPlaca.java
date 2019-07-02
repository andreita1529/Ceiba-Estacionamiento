package co.com.ceiba.parqueadero.paola.dominio.excepcion;

public class ExcepcionLetraPlaca extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionLetraPlaca(String mensaje) {
        super(mensaje);
    }

}
