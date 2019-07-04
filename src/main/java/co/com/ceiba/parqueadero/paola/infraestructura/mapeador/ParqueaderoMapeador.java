package co.com.ceiba.parqueadero.paola.infraestructura.mapeador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.infraestructura.adaptador.entidad.ParqueaderoEntidad;

@Component
public class ParqueaderoMapeador {
	
	public Parqueadero convertirADominio(ParqueaderoEntidad parqueaderoEntidad){
        Parqueadero parqueadero;

        if(parqueaderoEntidad == null){
            parqueadero = null;
        }
        else{
            parqueadero = new Parqueadero(parqueaderoEntidad.getId(), parqueaderoEntidad.getPlaca(), parqueaderoEntidad.getTipoVehiculo()
                    ,parqueaderoEntidad.getCilindraje(), parqueaderoEntidad.getFechaIngreso(), parqueaderoEntidad.getFechaSalida()
                    ,parqueaderoEntidad.getValorTotal());
        }

        return  parqueadero;
    }

    public ParqueaderoEntidad convertirAEntidad(Parqueadero parqueadero){
        ParqueaderoEntidad parqueaderoEntidad;
        if(parqueadero == null){
            parqueaderoEntidad = null;
        }else{
            parqueaderoEntidad = new ParqueaderoEntidad(parqueadero.getId(),parqueadero.getPlaca(), parqueadero.getTipoVehiculo()
                                                ,parqueadero.getCilindraje(),parqueadero.getFechaIngreso(),parqueadero.getFechaSalida(), parqueadero.getTotal());
        }
        
        return parqueaderoEntidad;
    }

    public List<Parqueadero> listaConvertirADominio(List<ParqueaderoEntidad> listaParqueaderoEntidad) {
        final List<Parqueadero> listParqueadero = new ArrayList<>();

        listaParqueaderoEntidad.forEach(parqueaderoEntidad -> listParqueadero.add(new Parqueadero(parqueaderoEntidad.getId()
                ,parqueaderoEntidad.getPlaca(),parqueaderoEntidad.getTipoVehiculo()
                ,parqueaderoEntidad.getCilindraje(),parqueaderoEntidad.getFechaIngreso(),parqueaderoEntidad.getFechaSalida()
                ,parqueaderoEntidad.getValorTotal())));

        return  listParqueadero;
    }

}
