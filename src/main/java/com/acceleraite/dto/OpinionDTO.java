package com.acceleraite.dto;

import lombok.*;

import java.util.Date;


@Data
public class OpinionDTO {

    private Long Id;
    private String Comentario;
    private Date Fecha;
    private Long ClienteId;
    private Long VehiculoId;

}
