package com.acceleraite.dto;


import lombok.*;

import java.util.Date;

@Data
public class DevolucionDTO {

    private Long Id;
    private String Descripcion;
    private Date FechaDevolucion;
    private String EstadoObjeto;
    private Long InspeccionId;
    private Long EstadoId;
    private Long ReservaId;

}
