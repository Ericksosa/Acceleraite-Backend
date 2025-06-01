package com.acceleraite.dto;

import lombok.*;

import java.util.List;

@Data
public class TipoCombustibleDTO {

    private Long Id;
    private String Nombre;
    private String Descripcion;
    private List<Long> VehiculoIds;
    private Long EstadoId;

}
