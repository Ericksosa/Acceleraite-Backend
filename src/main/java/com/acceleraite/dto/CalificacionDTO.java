package com.acceleraite.dto;

import lombok.*;

import java.util.Date;


@Data
public class CalificacionDTO {

    private Long Id;
    private double Puntuacion;
    private Date Fecha;
    private Long ClienteId;
    private Long VehiculoId;

}
