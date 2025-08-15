package com.acceleraite.dto;

import lombok.*;


@Data
public class MultimediaDTO {

    private Long id;
    private String tipo;
    private byte[] archivo;
    private String url;          // /api/vehiculos/{vehiculoId}/multimedia/{id}
    private String contentType;  // opcional
    private String nombreArchivo;// opcional
    private Long vehiculoId;
    private Long estadoId;
    private String estadoNombre;
}
