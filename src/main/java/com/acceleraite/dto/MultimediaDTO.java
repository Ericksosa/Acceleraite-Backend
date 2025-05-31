package com.acceleraite.dto;

import lombok.*;


@Data
public class MultimediaDTO {

    private Long Id;
    private String Tipo;
    private byte[] Archivo;
    private Long VehiculoId;
}
