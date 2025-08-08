package com.acceleraite.dto;

import lombok.*;

import java.util.Date;


@Data
public class CalificacionDTO {

    private Long id;
    private double puntuacion;
    private Date fecha;
    private Long clienteId;
    private Long vehiculoId;
    private Long estadoId;
    private String estadoNombre;
}
