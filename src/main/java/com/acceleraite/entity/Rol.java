package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = TablaNombre.Rol)
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Nombre, nullable = false)
    private String Nombre;

    @Column(name = TablaNombre.FechaRegistro, nullable = false) // Posible cambio a Tipo DATE
    private LocalDateTime FechaRegistro;

    @Column(name = TablaNombre.Descripcion, nullable = true)
    private String Descripcion;

    // Relacion
    @JsonIgnore
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "estado_id", foreignKey = @ForeignKey(name = "rol_estado_Id"))
    private Estado estado;
}
