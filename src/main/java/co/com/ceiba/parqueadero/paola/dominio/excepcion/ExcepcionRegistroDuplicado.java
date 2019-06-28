package co.com.ceiba.parqueadero.paola.dominio.excepcion;

public class ExcepcionRegistroDuplicado extends RuntimeException {

	private static final long serialVersionUID = 4946499836914146493L;

	public ExcepcionRegistroDuplicado(String mensaje) {
        super(mensaje);
    }

}
