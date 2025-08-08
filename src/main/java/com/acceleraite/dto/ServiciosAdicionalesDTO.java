package com.acceleraite.dto;

import lombok.*;

import java.util.List;

@Data
public class ServiciosAdicionalesDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String precio;
    private List<Long> reservaServiciosIds;
    private Long estadoId;
    private String estadoNombre;

}
