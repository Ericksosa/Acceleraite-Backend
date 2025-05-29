package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = TablaNombre.ServiciosAdicionales)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiciosAdicionales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    @Column(name = TablaNombre.Precio)
    private String Precio;

    // Relaciones de mappeo por otras tablas

    // Relaciones de toma de atributos de otras tablas
    @OneToMany(mappedBy = "serviciosAdicionales", cascade = CascadeType.ALL)
    private List<ReservaServicio> reservaServicios;
}
