package com.acceleraite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PenalizacionDTO     {

    private Long Id;
    private String Nombre;
    private String Tipo;
    private String MontoTotal;
    private String Descripcion;
    private Long EstadoId;
    private Long InspeccionId;

}
