package com.acceleraite.dto;

import lombok.*;

import java.util.List;


@Data
public class UsuarioDTO {

    private Long Id;
    private String NombreUsuario;
    private String Correo;
    private String Password;
    private Long RolId;
    private Long EstadoId;
}
