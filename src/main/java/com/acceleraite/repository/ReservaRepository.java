package com.acceleraite.repository;

import com.acceleraite.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByEstado_Id(Long estadoId);
}
