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

    @Column(name = "Tipo")
    private String tipo; // ej. "FOTO_EXTERIOR", "FOTO_INTERIOR"

    @Lob
    @Column(name = "Archivo", columnDefinition = "LONGBLOB", nullable = false)
    private byte[] archivo;

    @Column(name = "ContentType")
    private String contentType; // image/jpeg, image/png

    @Column(name = "NombreArchivo")
    private String nombreArchivo;

    // Relaciones de mappeo por otras tablas


    // Relaciones de toma de atributos de otras tablas
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculoId", foreignKey = @ForeignKey(name = "multimedia_vehiculo_id"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "estadoId", foreignKey = @ForeignKey(name = "multimedia_estado_id"))
    private Estado estado;

}
