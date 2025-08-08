package com.acceleraite.dto;

import lombok.*;

import java.util.Date;


@Data
public class OpinionDTO {

    private Long id;
    private String comentario;
    private Date fecha;
    private Long clienteId;
    private Long vehiculoId;
    private Long estadoId;
    private String estadoNombre;
    private String vehiculoNombre;


}
