package com.acceleraite.dto;

import lombok.*;

import java.util.List;

@Data
public class ClienteDTO {

    private Long Id;
    private String Nombre;
    private String Apellido;
    private Long TarjetaCR;
    private Double LimiteCredito;
    private String TipoPersona;
    private List<Long> CalificacionesIds;
    private List<Long> OpinionesIds;
    private Long UsuarioId;
    private Long EstadoId;

}
