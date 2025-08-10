package com.acceleraite.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombreUsuario;
    private String correo;
    private String password;
    private Long rolId;
    private String rolNombre; // <-- nuevo
    private Long estadoId;
}