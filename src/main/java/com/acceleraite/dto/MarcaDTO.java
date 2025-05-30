package com.acceleraite.dto;

import lombok.*;

import java.util.List;

@Data
public class MarcaDTO {

    private long Id;
    private String Nombre;
    private String Descripcion;
    private List<Long> ModelosIds;
    private Long EstadoId;

}