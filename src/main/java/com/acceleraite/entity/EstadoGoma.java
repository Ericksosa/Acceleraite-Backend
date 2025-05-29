package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = TablaNombre.EstadoGoma)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EstadoGoma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Descripcion)
    private String Descripciom;

    // Relaciones de mappeo por otras tablas

    @OneToOne(mappedBy = "estadoGoma", cascade = CascadeType.ALL)
    private Inspeccion inspeccion;

    // Relaciones de toma de atributos de otras tablas

}
