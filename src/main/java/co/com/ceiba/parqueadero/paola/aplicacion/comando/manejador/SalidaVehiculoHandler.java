package co.com.ceiba.parqueadero.paola.aplicacion.comando.manejador;

import co.com.ceiba.parqueadero.paola.dominio.servicio.ActualizarSalidaVehiculoParqueaderoServicio;

public class SalidaVehiculoHandler {
	
	private final ActualizarSalidaVehiculoParqueaderoServicio actualizarServicio;

    public SalidaVehiculoHandler(ActualizarSalidaVehiculoParqueaderoServicio servicio){
        this.actualizarServicio = servicio;
    }

    public  void actualizar(String placa){
        this.actualizarServicio.actualizar(placa);
    }

}
