package com.acceleraite.repository;

import com.acceleraite.entity.TipoCombustible;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoCombustibleRepository extends JpaRepository<TipoCombustible, Long> {
    List<TipoCombustible> findByEstado_Id(Long estadoId);
}
