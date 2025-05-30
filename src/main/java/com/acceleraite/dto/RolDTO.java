package com.acceleraite.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class RolDTO {

    private Long Id;
    private String Nombre;
    private LocalDateTime FechaRegistro; // Posible cambio a Tipo DATE
    private String Descripcion;
    private List<Long> UsuariosIds;

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
//    public List<Long> getUsuariosIds() {
//        return UsuariosIds;
//    }
//
//    public void setUsuariosIds(List<Long> usuariosIds) {
//        UsuariosIds = usuariosIds;
//    }
}
