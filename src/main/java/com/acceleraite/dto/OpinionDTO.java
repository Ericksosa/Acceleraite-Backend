package com.acceleraite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OpinionDTO {

    private Long Id;
    private String Comentario;
    private Date Fecha;
    private Long ClienteId;
    private Long VehiculoId;

}
