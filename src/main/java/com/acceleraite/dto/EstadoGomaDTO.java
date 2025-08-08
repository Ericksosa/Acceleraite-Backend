package com.acceleraite.dto;

import lombok.*;

@Data
public class EstadoGomaDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long inspeccionId;
    private Long estadoId;
    private String estadoNombre;
    private String inspeccionNombre;

}
