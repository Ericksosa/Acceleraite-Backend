package com.acceleraite.dto;

import lombok.*;

import java.util.List;

@Data
public class ServiciosAdicionalesDTO {

    private Long Id;
    private String Nombre;
    private String Descripcion;
    private String Precio;
    private List<Long> ReservaServiciosIds;
}
