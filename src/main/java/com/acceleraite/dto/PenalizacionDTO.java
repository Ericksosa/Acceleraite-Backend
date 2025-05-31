package com.acceleraite.dto;

import lombok.*;


@Data
public class PenalizacionDTO{

    private Long Id;
    private String Nombre;
    private String Tipo;
    private String MontoTotal;
    private String Descripcion;
    private Long EstadoId;
    private Long InspeccionId;

}
