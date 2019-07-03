package co.com.ceiba.parqueadero.paola.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.paola.aplicacion.comando.ParqueaderoComando;
import co.com.ceiba.parqueadero.paola.aplicacion.comando.manejador.EntradaVehiculoHandler;
import co.com.ceiba.parqueadero.paola.aplicacion.comando.manejador.SalidaVehiculoHandler;
import co.com.ceiba.parqueadero.paola.aplicacion.consulta.ListaVehiculoHandler;
import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;

import java.util.List;

@RestController
@RequestMapping("/parqueadero")
@CrossOrigin("http://localhost:4200")
public class ParqueaderoControlador {

	private EntradaVehiculoHandler entradaVehiculoHandler;
	private SalidaVehiculoHandler salidaVehiculoHandler;
	private ListaVehiculoHandler listaVehiculoHandler;
	
	@Autowired
    public ParqueaderoControlador(EntradaVehiculoHandler entradaVehiculoHandler, 
    		SalidaVehiculoHandler salidaVehiculoHandler, ListaVehiculoHandler listaVehiculoHandler){
        this.entradaVehiculoHandler = entradaVehiculoHandler;
        this.salidaVehiculoHandler = salidaVehiculoHandler;
        this.listaVehiculoHandler = listaVehiculoHandler;
    }
	
	@RequestMapping(method= RequestMethod.GET)
    public List<Parqueadero> ListaVehiculos() {
        return this.listaVehiculoHandler.listaVehiculos();
    }

    @PostMapping
    public void getEntrada(@RequestBody ParqueaderoComando parqueaderoComando) {
        this.entradaVehiculoHandler.crear(parqueaderoComando);
    }

    @PutMapping("/{placa}")
    public void getSalida(@PathVariable("placa") String placa) {
        this.salidaVehiculoHandler.actualizar(placa);
    }
}
