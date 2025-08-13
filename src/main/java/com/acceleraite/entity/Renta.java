package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = TablaNombre.Renta)
@Data
public class Renta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.Descripcion)
    private String descripcion;

    @Column(name = TablaNombre.FechaInicio)
    private LocalDate fechaInicio;

    @Column(name = TablaNombre.FechaVencimiento)
    private LocalDate fechaVencimiento;

    @Column(name = TablaNombre.MillajeInicio)
    private Long millajeInicio;

    // Relaciones de mappeo por otras tablas

    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "ReservaId", foreignKey = @ForeignKey(name = "renta_reserva_id"))
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "renta_estado_id"))
    private Estado estado;


}
