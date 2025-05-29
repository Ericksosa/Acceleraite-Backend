package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = TablaNombre.Renta)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Renta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    @Column(name = TablaNombre.FechaInicio)
    private Date FechaInicio;

    @Column(name = TablaNombre.FechaVencimiento)
    private Date FechaVencimiento;

    @Column(name = TablaNombre.MillajeInicio)
    private Long MillajeInicio;

    // Relaciones de mappeo por otras tablas

    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "ReservaId", foreignKey = @ForeignKey(name = "renta_reserva_id"))
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "renta_estado_id"))
    private Estado estado;


}
