package com.acceleraite.dto;

import lombok.*;

import java.util.List;

@Data
public class TipoCombustibleDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private List<Long> vehiculoIds;
    private Long estadoId;
    private String estadoNombre;

}
