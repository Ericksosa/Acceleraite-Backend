package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = TablaNombre.Rol)
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.Nombre, nullable = false)
    private String nombre;

    @Column(name = TablaNombre.FechaRegistro, nullable = false) // Posible cambio a Tipo DATE
    private LocalDate fechaRegistro;

    @Column(name = TablaNombre.Descripcion, nullable = true)
    private String descripcion;

    // Relacion
    @JsonIgnore
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();

    // Relacion de toma de atributos
    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "rol_estado_id"))
    private Estado estado;

}
