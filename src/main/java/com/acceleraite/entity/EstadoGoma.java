package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TablaNombre.EstadoGoma)
@Data
public class EstadoGoma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = TablaNombre.Nombre)
    private String nombre;

    @Column(name = TablaNombre.Descripcion)
    private String descripciom;

    // Relaciones de mappeo por otras tablas

    @OneToOne(mappedBy = "estadoGoma", cascade = CascadeType.ALL)
    private Inspeccion inspeccion;

    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "EstadoGoma_estado_id"))
    private Estado estado;

}
