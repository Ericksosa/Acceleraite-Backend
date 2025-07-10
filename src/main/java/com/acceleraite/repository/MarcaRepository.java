package com.acceleraite.repository;

import com.acceleraite.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    List<Marca> findByEstado_Id(Long estadoId);
}
