package com.acceleraite.seed;

import com.acceleraite.entity.Estado;
import com.acceleraite.repository.EstadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class EstadoSeeder implements CommandLineRunner {

    private final EstadoRepository estadoRepository;

    public EstadoSeeder(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public void run(String... args) {
        if (estadoRepository.count() == 0) {
            Estado activo = new Estado();
            activo.setNombre("Activo");
            activo.setDescripcion("Estado activo");
            estadoRepository.save(activo);

            Estado inactivo = new Estado();
            inactivo.setNombre("Inactivo");
            inactivo.setDescripcion("Estado inactivo");
            estadoRepository.save(inactivo);

        }
    }
}
