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

    // Getter y Setters

//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }
//
//    public String getNombre() {
//        return Nombre;
//    }
//
//    public void setNombre(String nombre) {
//        Nombre = nombre;
//    }
//
//    public LocalDateTime getFechaRegistro() {
//        return FechaRegistro;
//    }
//
//    public void setFechaRegistro(LocalDateTime fechaRegistro) {
//        FechaRegistro = fechaRegistro;
//    }
//
//    public String getDescripcion() {
//        return Descripcion;
//    }
//
//    public void setDescripcion(String descripcion) {
//        Descripcion = descripcion;
//    }
//
//    public List<Usuario> getUsuarios() {
//        return usuarios;
//    }
//
//    public void setUsuarios(List<Usuario> usuarios) {
//        this.usuarios = usuarios;
//    }
}
