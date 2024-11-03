package dds.api_rest1.Domain.EstrategiasBusqueda;

import dds.api_rest1.Domain.PuntoGeografico;
import dds.api_rest1.Domain.RepositorioPuntosGeograficos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecomendacionPorCercania implements EstrategiaRecomendacion{

    private final RepositorioPuntosGeograficos repoPuntosGeo;

    @Autowired
    public RecomendacionPorCercania(RepositorioPuntosGeograficos repoPuntosGeo) {
        this.repoPuntosGeo = repoPuntosGeo;
    }

    @Override
    public List<PuntoGeografico> recommendPoints(double latitude, double longitude, double radius){
        double latitudDistancia = (radius / 111); //* Math.cos(Math.toRadians(latitude));
        double longitudDistancia = (radius / 111); // * Math.sin(Math.toRadians(longitude));

        return repoPuntosGeo.findByLatitudeBetweenAndLongitudeBetween(
                latitude - latitudDistancia, latitude + latitudDistancia,
                longitude - longitudDistancia, longitude + longitudDistancia
        );
    }
}
