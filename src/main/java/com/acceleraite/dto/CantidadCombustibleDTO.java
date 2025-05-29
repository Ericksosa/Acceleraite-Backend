package com.acceleraite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CantidadCombustibleDTO {

    private Long Id;
    private String Nombre;
    private String Descripcion;
    private Long InspeccionId;
}
