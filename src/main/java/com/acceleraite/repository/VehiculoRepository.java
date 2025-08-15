package com.acceleraite.repository;

import com.acceleraite.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findByEstado_Id(Long estadoId);

    @Query("SELECT DISTINCT v FROM Vehiculo v LEFT JOIN FETCH v.multimedia")
    List<Vehiculo> findAllConMultimedia();

}
