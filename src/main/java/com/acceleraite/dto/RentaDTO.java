package com.acceleraite.dto;

import lombok.*;

import java.util.Date;


@Data
public class RentaDTO {

    private Long Id;
    private String Descripcion;
    private Date FechaInicio;
    private Date FechaVencimiento;
    private Long MillajeInicio;
    private Long ReservaId;
    private Long EstadoId;


}
