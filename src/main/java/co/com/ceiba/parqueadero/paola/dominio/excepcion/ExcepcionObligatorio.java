package co.com.ceiba.parqueadero.paola.dominio.excepcion;

public class ExcepcionObligatorio extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionObligatorio(String mensaje) {
        super(mensaje);
    }
}

