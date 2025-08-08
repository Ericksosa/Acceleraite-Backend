package com.acceleraite.dto;

import lombok.*;


@Data
public class PenalizacionDTO{

    private Long id;
    private String nombre;
    private String tipo;
    private String montoTotal;
    private String descripcion;
    private Long estadoId;
    private Long inspeccionId;
    private String estadoNombre;
    private String inspeccionNombre;

}
