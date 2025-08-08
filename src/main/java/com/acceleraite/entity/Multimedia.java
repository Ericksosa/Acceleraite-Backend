package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TablaNombre.Multimedia)
@Data
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.Tipo)
    private String tipo;

    @Lob
    @Column(name = TablaNombre.Archivo)
    private byte[] archivo;

    // Relaciones de mappeo por otras tablas


    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "vehiculoId", foreignKey = @ForeignKey(name = "multimedia_vehiculo_id"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "estadoId", foreignKey = @ForeignKey(name = "multimedia_estado_id"))
    private Estado estado;

}
