package dds.api_rest1.Domain;

import dds.api_rest1.Domain.EstrategiasBusqueda.EstrategiaRecomendacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoGeograficoService {

    @Autowired
    private RepositorioPuntosGeograficos repoPuntosGeograficos;

    private EstrategiaRecomendacion estrategiaRecomendacion;

    @Autowired
    public PuntoGeograficoService(RepositorioPuntosGeograficos repoPuntosGeograficos,
                                  @Qualifier("recomendacionPorCercania") EstrategiaRecomendacion estrategiaRecomendacion) {
        this.repoPuntosGeograficos = repoPuntosGeograficos;
        this.estrategiaRecomendacion = estrategiaRecomendacion;
    }

    public List<PuntoGeografico> findNearbyPoints(double latitude, double longitude, double radioKm) {
        return estrategiaRecomendacion.recommendPoints(latitude, longitude, radioKm);
    }

    public void setEstrategiaRecomendacion(EstrategiaRecomendacion estrategiaRecomendacion) {
        this.estrategiaRecomendacion = estrategiaRecomendacion;
    }
}
