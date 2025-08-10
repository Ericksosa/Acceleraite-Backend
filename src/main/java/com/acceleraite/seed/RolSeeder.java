package com.acceleraite.seed;

import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Rol;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RolSeeder implements CommandLineRunner {

    private final RolRepository rolRepository;
    private final EstadoRepository estadoRepository;

    public RolSeeder(RolRepository rolRepository, EstadoRepository estadoRepository) {
        this.rolRepository = rolRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public void run(String... args) {
        if (estadoRepository.count() == 0) {
            Estado activo = new Estado();
            activo.setNombre("Activo");
            activo.setDescripcion("Estado activo para registros");
            estadoRepository.save(activo);

            Estado inactivo = new Estado();
            inactivo.setNombre("Inactivo");
            inactivo.setDescripcion("Estado inactivo para registros");
            estadoRepository.save(inactivo);
        }

        Estado activo = estadoRepository.findById(1L).orElseThrow();

        if (rolRepository.count() == 0) {
            Rol administrador = new Rol();
            administrador.setNombre("Administrador");
            administrador.setDescripcion("Rol Administrador");
            administrador.setFechaRegistro(LocalDateTime.now());
            administrador.setEstado(activo);
            rolRepository.save(administrador);

            Rol cliente = new Rol();
            cliente.setNombre("Cliente");
            cliente.setDescripcion("Rol Cliente");
            cliente.setFechaRegistro(LocalDateTime.now());
            cliente.setEstado(activo);
            rolRepository.save(cliente);
        }
    }
}