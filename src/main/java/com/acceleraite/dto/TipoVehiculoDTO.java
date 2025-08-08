package com.acceleraite.dto;

import lombok.*;

@Data
public class TipoVehiculoDTO {

    private long id;
    private String nombre;
    private String descripcion;
    private Long estadoId;
    private String estadoNombre;
}
