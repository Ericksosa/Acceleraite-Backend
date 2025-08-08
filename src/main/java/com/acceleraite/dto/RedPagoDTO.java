package com.acceleraite.dto;

import lombok.*;

import java.util.List;


@Data
public class RedPagoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long estadoId;
    private String estadoNombre;
}
