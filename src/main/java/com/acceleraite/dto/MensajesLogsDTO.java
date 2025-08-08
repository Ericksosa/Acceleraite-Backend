package com.acceleraite.dto;

import lombok.*;

@Data
public class MensajesLogsDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long estadoId;
    private String estadoNombre;
}
