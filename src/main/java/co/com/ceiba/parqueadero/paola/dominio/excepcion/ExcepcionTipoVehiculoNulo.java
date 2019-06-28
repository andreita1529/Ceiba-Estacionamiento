package co.com.ceiba.parqueadero.paola.dominio.excepcion;

public class ExcepcionTipoVehiculoNulo extends RuntimeException  {

	private static final long serialVersionUID = 5583769275540578550L;

	public ExcepcionTipoVehiculoNulo(String mensaje) {
        super(mensaje);
    }
}