package com.acceleraite.dto;

import lombok.*;

import java.util.List;

@Data
public class ClienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Long tarjetaCR;
    private Double limiteCredito;
    private String tipoPersona;
    private Long usuarioId;
    private Long estadoId;
    private String estadoNombre;

}
