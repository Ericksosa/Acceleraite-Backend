package com.acceleraite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MultimediaDTO {

    private Long Id;
    private String Tipo;
    private byte[] Archivo;
    private Long VehiculoId;
}
