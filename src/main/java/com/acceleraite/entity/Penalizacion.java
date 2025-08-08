package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TablaNombre.Penalizacion)
@Data
public class Penalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.Nombre)
    private String nombre;

    @Column(name = TablaNombre.Tipo)
    private String tipo;

    @Column(name = TablaNombre.MontoTotal)
    private String montoTotal;

    @Column(name = TablaNombre.Descripcion)
    private String descripcion;

    // Relaciones de mappeo por otras tablas


    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "penalizacion_estado_id"))
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "InspeccionId", foreignKey = @ForeignKey(name = "penalizacion_inspeccion_id"))
    private Inspeccion inspeccion;

}
