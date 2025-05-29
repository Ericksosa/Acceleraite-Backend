package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = TablaNombre.Multimedia)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Tipo)
    private String Tipo;

    @Lob
    @Column(name = TablaNombre.Archivo)
    private byte[] archivo;

    // Relaciones de mappeo por otras tablas


    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "vehiculoId", foreignKey = @ForeignKey(name = "multimedia_vehiculo_id"))
    private Vehiculo vehiculo;
}
