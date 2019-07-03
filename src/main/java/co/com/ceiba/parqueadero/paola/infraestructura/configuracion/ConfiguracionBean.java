package co.com.ceiba.parqueadero.paola.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.parqueadero.paola.aplicacion.comando.manejador.EntradaVehiculoHandler;
import co.com.ceiba.parqueadero.paola.aplicacion.comando.manejador.SalidaVehiculoHandler;
import co.com.ceiba.parqueadero.paola.aplicacion.consulta.ListaVehiculoHandler;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.IParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.dominio.servicio.*;

@Configuration
public class ConfiguracionBean {
	
	@Bean
    public EntradaVehiculoHandler entradaVehiculoHandler(CrearVehiculoParqueaderoServicio crearServicio) {
        return new EntradaVehiculoHandler(crearServicio);
    }

    @Bean
    public CrearVehiculoParqueaderoServicio crearServicio(IParqueaderoRepositorio parqueaderoRepositorio){
        return new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }

    @Bean
    public ListaVehiculoHandler listaVehiculoHandler(BuscarVehiculoParqueaderoServicio buscarListaServicio) {
        return new ListaVehiculoHandler(buscarListaServicio);
    }
    
    @Bean
    public  BuscarVehiculoParqueaderoServicio listaVehiculoServicio(IParqueaderoRepositorio parqueaderoRepositorio){
        return new BuscarVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }
    
    @Bean
    public SalidaVehiculoHandler salidaVehiculoHandler(ActualizarSalidaVehiculoParqueaderoServicio actualizarServicio) {
        return new SalidaVehiculoHandler(actualizarServicio);
    }
    
    @Bean
    public ActualizarSalidaVehiculoParqueaderoServicio registerExitService(IParqueaderoRepositorio parqueaderoRepositorio){
        return new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }
    
    
}
