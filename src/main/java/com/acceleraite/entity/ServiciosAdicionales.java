package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = TablaNombre.ServiciosAdicionales)
@Data
public class ServiciosAdicionales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = TablaNombre.Nombre)
    private String nombre;

    @Column(name = TablaNombre.Descripcion)
    private String descripcion;

    @Column(name = TablaNombre.Precio)
    private String Precio;

    // Relaciones de mappeo por otras tablas

    // Relaciones de toma de atributos de otras tablas
    @OneToMany(mappedBy = "serviciosAdicionales", cascade = CascadeType.ALL)
    private List<ReservaServicio> reservaServicios;

    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "serviciosAdicionales_estado_id"))
    private Estado estado;
}
