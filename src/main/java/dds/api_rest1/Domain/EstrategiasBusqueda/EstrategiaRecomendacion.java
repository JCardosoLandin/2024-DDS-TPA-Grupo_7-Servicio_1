package dds.api_rest1.Domain.EstrategiasBusqueda;

import dds.api_rest1.Domain.PuntoGeografico;

import java.util.List;

public interface EstrategiaRecomendacion {
    List<PuntoGeografico> recommendPoints(double latitude, double longitude, double radius);
}
