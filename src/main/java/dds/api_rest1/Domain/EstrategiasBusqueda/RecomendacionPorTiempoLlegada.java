package dds.api_rest1.Domain.EstrategiasBusqueda;

import dds.api_rest1.Domain.PuntoGeografico;
import dds.api_rest1.Domain.RepositorioPuntosGeograficos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecomendacionPorTiempoLlegada implements EstrategiaRecomendacion{

    private final RepositorioPuntosGeograficos repoPuntosGeo;

    @Autowired
    public RecomendacionPorTiempoLlegada(RepositorioPuntosGeograficos repoPuntosGeo) {
        this.repoPuntosGeo = repoPuntosGeo;
    }

    @Override
    public List<PuntoGeografico> recommendPoints(double longitude, double latitude, double radius){
        throw new UnsupportedOperationException("Esta funcionalidad aun no esta disponible");
    }
}
