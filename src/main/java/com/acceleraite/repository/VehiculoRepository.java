package com.acceleraite.repository;

import com.acceleraite.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findByEstado_Id(Long estadoId);
}
