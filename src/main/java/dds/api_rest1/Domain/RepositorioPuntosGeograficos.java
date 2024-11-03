package dds.api_rest1.Domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPuntosGeograficos extends JpaRepository<PuntoGeografico, Long> {
    // Spring Data JPA deberia armar esto por si solo
    List<PuntoGeografico> findByLatitudeBetweenAndLongitudeBetween(double minLat, double maxLat, double minLon, double maxLon);
}
