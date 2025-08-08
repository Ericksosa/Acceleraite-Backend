package com.acceleraite.dto;

import lombok.*;

import java.util.Date;


@Data
public class RentaDTO {

    private Long id;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaVencimiento;
    private Long millajeInicio;
    private Long reservaId;
    private Long estadoId;
    private String estadoNombre;
    private String reservaNombre;


}
