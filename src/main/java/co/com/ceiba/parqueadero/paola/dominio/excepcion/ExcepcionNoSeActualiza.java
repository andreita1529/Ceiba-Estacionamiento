package co.com.ceiba.parqueadero.paola.dominio.excepcion;

public class ExcepcionNoSeActualiza extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionNoSeActualiza(String mensaje) {
        super(mensaje);
    }

}
