package com.acceleraite.dto;


import lombok.*;

import java.util.Date;

@Data
public class DevolucionDTO {

    private Long id;
    private String descripcion;
    private Date fechaDevolucion;
    private String estadoObjeto;
    private Long inspeccionId;
    private Long estadoId;
    private Long reservaId;
    private String estadoNombre;
    private String inspeccionNombre;

}
