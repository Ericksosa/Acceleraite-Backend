package com.acceleraite.dto;

import lombok.*;

import java.util.List;


@Data
public class UsuarioDTO {

    private Long id;
    private String nombreUsuario;
    private String correo;
    private String password;
    private Long rolId;
    private Long estadoId;
    private String estadoNombre;
    private String rolNombre;

}

