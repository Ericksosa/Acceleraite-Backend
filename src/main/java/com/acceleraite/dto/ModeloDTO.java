package com.acceleraite.dto;

import lombok.*;

@Data
public class ModeloDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long marcaId;
    private Long estadoId;
    private String estadoNombre;
    private String marcaNombre;

}
