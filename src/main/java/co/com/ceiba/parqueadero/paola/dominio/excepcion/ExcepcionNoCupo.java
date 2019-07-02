package co.com.ceiba.parqueadero.paola.dominio.excepcion;

public class ExcepcionNoCupo extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionNoCupo(String mensaje) {
        super(mensaje);
    }

}
