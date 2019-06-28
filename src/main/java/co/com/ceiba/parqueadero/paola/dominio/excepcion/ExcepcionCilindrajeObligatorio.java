package co.com.ceiba.parqueadero.paola.dominio.excepcion;

public class ExcepcionCilindrajeObligatorio extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionCilindrajeObligatorio(String mensaje) {
        super(mensaje);
    }

}
