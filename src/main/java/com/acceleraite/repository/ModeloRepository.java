package com.acceleraite.repository;

import com.acceleraite.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    List<Modelo> findByEstado_Id(Long estadoId);
}
