package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TablaNombre.ReservaServicio)
@Data
public class ReservaServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Cantidad)
    private int Cantidad;

    // Relaciones de mappeo por otras tablas

    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false, foreignKey = @ForeignKey(name = "reservaServicio_reserva_id"))
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false, foreignKey = @ForeignKey(name = "reservaServicio_servicio_id"))
    private ServiciosAdicionales serviciosAdicionales;

}
