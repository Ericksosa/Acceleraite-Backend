package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = TablaNombre.TipoVehiculo)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoVehiculo {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    // Relaciones de mappeo por otras tablas


    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "EstadoId",foreignKey = @ForeignKey(name = "TipoVehiculo_estado_id"))
    private Estado estado;
}
