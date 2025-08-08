package com.acceleraite.dto;

import lombok.*;


@Data
public class MetodoPagoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long estadoId;
    private String estadoNombre;
}
