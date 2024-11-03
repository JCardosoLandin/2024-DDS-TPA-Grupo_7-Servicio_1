package dds.api_rest1.Domain;

import dds.api_rest1.Domain.EstrategiasBusqueda.RecomendacionPorCercania;
import dds.api_rest1.Domain.EstrategiasBusqueda.RecomendacionPorTiempoLlegada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownServiceException;
import java.util.List;

@RestController
@RequestMapping("/api/points")
public class PuntoGeoController {

    @Autowired
    private PuntoGeograficoService puntoGeoService;

    @Autowired
    private  RepositorioPuntosGeograficos repoPuntosGeo;

    @GetMapping("/nearby")
    public ResponseEntity<?> getNearbyPoints(@RequestParam double latitude,
                                                       @RequestParam double longitude,
                                                       @RequestParam(defaultValue = "5") double radioKm,
                                                       @RequestParam(defaultValue = "METROS") TipoEstrategia tipoEstrategia) {

        try {
            switch (tipoEstrategia) {
                case METROS:
                    puntoGeoService.setEstrategiaRecomendacion(new RecomendacionPorCercania(repoPuntosGeo));
                    break;
                case TIEMPO_LLEGADA:
                    puntoGeoService.setEstrategiaRecomendacion(new RecomendacionPorTiempoLlegada(repoPuntosGeo));
                    break;
                default:
                    throw new UnknownServiceException("Operacion desconocida");
            }
            List<PuntoGeografico> puntos = puntoGeoService.findNearbyPoints(latitude, longitude, radioKm);
            return ResponseEntity.ok(puntos);
        }
        catch (UnsupportedOperationException e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(e.getMessage());
        } catch (UnknownServiceException e) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(e.getMessage());
        }
    }
}
