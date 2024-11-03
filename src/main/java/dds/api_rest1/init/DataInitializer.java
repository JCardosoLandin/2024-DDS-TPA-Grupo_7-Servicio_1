package dds.api_rest1.init;

import dds.api_rest1.Domain.PuntoGeografico;
import dds.api_rest1.Domain.RepositorioPuntosGeograficos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(RepositorioPuntosGeograficos repoPuntosGeo) {
        return (args) -> {
            PuntoGeografico punto1 = new PuntoGeografico();
            punto1.setLatitude(34.0522); // Los Angeles
            punto1.setLongitude(-118.2437);
            repoPuntosGeo.save(punto1);

            PuntoGeografico punto2 = new PuntoGeografico();
            punto2.setLatitude(40.7306); // New York
            punto2.setLongitude(-73.9352);
            repoPuntosGeo.save(punto2);

            PuntoGeografico punto3 = new PuntoGeografico();
            punto3.setLatitude(40.7488); // Empire State
            punto3.setLongitude(-73.9857);
            repoPuntosGeo.save(punto3);

            PuntoGeografico punto4 = new PuntoGeografico();
            punto4.setLatitude(37.7749); // San Francisco
            punto4.setLongitude(-122.4194);
            repoPuntosGeo.save(punto4);

            PuntoGeografico punto5 = new PuntoGeografico();
            punto5.setLatitude(51.5074); // Londres
            punto5.setLongitude(-0.1278);
            repoPuntosGeo.save(punto5);

            PuntoGeografico punto6 = new PuntoGeografico();
            punto6.setLatitude(48.8566); // Paris
            punto6.setLongitude(2.3522);
            repoPuntosGeo.save(punto6);

            PuntoGeografico punto7 = new PuntoGeografico();
            punto7.setLatitude(-34.6037); // Buenos Aires 1
            punto7.setLongitude(-58.3816);
            repoPuntosGeo.save(punto7);

            PuntoGeografico punto8 = new PuntoGeografico();
            punto8.setLatitude(-34.6150); // Buenos Aires 2
            punto8.setLongitude(-58.3822);
            repoPuntosGeo.save(punto8);
        };
    }
}

