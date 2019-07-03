package co.com.ceiba.parqueadero.paola.aplicacion.consulta;

import java.util.List;

import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.servicio.BuscarVehiculoParqueaderoServicio;

public class ListaVehiculoHandler {

	private final BuscarVehiculoParqueaderoServicio buscarServicio;

    public ListaVehiculoHandler(BuscarVehiculoParqueaderoServicio servicio){
        this.buscarServicio = servicio;
    }

    public List<Parqueadero> listaVehiculos(){
        return this.buscarServicio.buscar();
    }
}
