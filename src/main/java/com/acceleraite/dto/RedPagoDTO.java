package com.acceleraite.dto;

import lombok.*;

import java.util.List;


@Data
public class RedPagoDTO {

    private Long Id;
    private String Nombre;
    private String Descripcion;
    private List<Long> PagosIds;
    private Long EstadoId;
}
