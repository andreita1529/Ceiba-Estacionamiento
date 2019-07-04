package co.com.ceiba.parqueadero.paola.infraestructura.adaptador;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.paola.dominio.modelo.Parqueadero;
import co.com.ceiba.parqueadero.paola.dominio.puerto.repositorio.ParqueaderoRepositorio;
import co.com.ceiba.parqueadero.paola.infraestructura.adaptador.entidad.ParqueaderoEntidad;
import co.com.ceiba.parqueadero.paola.infraestructura.mapeador.ParqueaderoMapeador;
import co.com.ceiba.parqueadero.paola.infraestructura.adaptador.repositorio.ParqueaderoRepositorioJPA;

@Repository
public class ParqueaderoRepositorioH2Adaptador implements ParqueaderoRepositorio{

	private ParqueaderoRepositorioJPA parqueaderoRepositorioJPA;
	private ParqueaderoMapeador mapeador;
	
	public ParqueaderoRepositorioH2Adaptador(ParqueaderoRepositorioJPA parqueaderoRepositorioJPA, ParqueaderoMapeador mapeador){
        this.parqueaderoRepositorioJPA = parqueaderoRepositorioJPA;
        this.mapeador = mapeador;
    }
	    
	@Override
	public Parqueadero crearVehiculo(Parqueadero parqueadero) {
		ParqueaderoEntidad parqueaderoEntidad = parqueaderoRepositorioJPA.save(mapeador.convertirAEntidad(parqueadero));
		return mapeador.convertirADominio(parqueaderoEntidad);
	}


	@Override
	public int cuposPorTipoVehiculo(String tipoVehiculo) {
		return parqueaderoRepositorioJPA.cuposPorTipoVehiculo(tipoVehiculo);
	}

	@Override
	public boolean existeVehiculo(String placa) {
		return parqueaderoRepositorioJPA.existeVehiculo(placa);
	}

	@Override
	public List<Parqueadero> buscarRegistroVehiculos() {
		List<ParqueaderoEntidad> listaParqueaderoEntidad = parqueaderoRepositorioJPA.buscarRegistroVehiculos();
		return mapeador.listaConvertirADominio(listaParqueaderoEntidad);
	}

	@Override
	public Parqueadero buscarPorPlaca(String placa) {
		ParqueaderoEntidad parqueaderoEntidad = parqueaderoRepositorioJPA.buscarPorPlaca(placa);
		return mapeador.convertirADominio(parqueaderoEntidad);
	}

}
