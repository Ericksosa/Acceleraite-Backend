package com.acceleraite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiciosAdicionalesDTO {

    private Long Id;
    private String Nombre;
    private String Descripcion;
    private String Precio;
    private List<Long> ReservaServiciosIds;
}
