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
public class CalificacionDTO {

    private Long Id;
    private double Puntuacion;
    private Date Fecha;
    private Long ClienteId;
    private Long VehiculoId;

}
