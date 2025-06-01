package com.acceleraite.repository;

import com.acceleraite.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByEstado_Id(Long estadoId);
}
