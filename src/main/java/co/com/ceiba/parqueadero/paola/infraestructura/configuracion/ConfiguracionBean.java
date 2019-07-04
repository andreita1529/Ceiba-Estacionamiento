package co.com.ceiba.parqueadero.paola.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.parqueadero.paola.aplicacion.comando.manejador.EntradaVehiculoHandler;
import co.com.ceiba.parqueadero.paola.aplicacion.comando.manejador.SalidaVehiculoHandler;
import co.com.ceiba.parqueadero.paola.aplicacion.consulta.ListaVehiculoHandler;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.ParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.dominio.servicio.*;

@Configuration
public class ConfiguracionBean {
	
	@Bean
    public EntradaVehiculoHandler entradaVehiculoHandler(CrearVehiculoParqueaderoServicio crearServicio) {
        return new EntradaVehiculoHandler(crearServicio);
    }

    @Bean
    public CrearVehiculoParqueaderoServicio crearServicio(ParqueaderoRepositorio parqueaderoRepositorio){
        return new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }

    @Bean
    public ListaVehiculoHandler listaVehiculoHandler(BuscarVehiculoParqueaderoServicio buscarListaServicio) {
        return new ListaVehiculoHandler(buscarListaServicio);
    }
    
    @Bean
    public  BuscarVehiculoParqueaderoServicio listaVehiculoServicio(ParqueaderoRepositorio parqueaderoRepositorio){
        return new BuscarVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }
    
    @Bean
    public SalidaVehiculoHandler salidaVehiculoHandler(ActualizarSalidaVehiculoParqueaderoServicio actualizarServicio) {
        return new SalidaVehiculoHandler(actualizarServicio);
    }
    
    @Bean
    public ActualizarSalidaVehiculoParqueaderoServicio registerExitService(ParqueaderoRepositorio parqueaderoRepositorio){
        return new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }
    
    
}
