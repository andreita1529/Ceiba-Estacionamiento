package co.com.ceiba.parqueadero.paola.dominio.excepcion;

public class ExcepcionValidarPlaca extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionValidarPlaca(String mensaje) {
        super(mensaje);
    }
}

