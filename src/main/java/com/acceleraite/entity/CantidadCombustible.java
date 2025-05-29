package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = TablaNombre.CantidadCombustible)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CantidadCombustible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    // Relaciones de mappeo por otras tablas
    @OneToOne(mappedBy = "cantidadCombustible", cascade = CascadeType.ALL)
    private Inspeccion inspeccion;

    // Relaciones de toma de atributos de otras tablas


}
