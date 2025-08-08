package com.acceleraite.dto;

import lombok.*;


@Data
public class MultimediaDTO {

    private Long id;
    private String tipo;
    private byte[] archivo;
    private Long vehiculoId;
    private Long estadoId;
    private String estadoNombre;
}
