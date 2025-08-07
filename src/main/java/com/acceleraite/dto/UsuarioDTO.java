package com.acceleraite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;

//    @JsonProperty("NombreUsuario")
    private String nombreUsuario;

//    @JsonProperty("Correo")
    private String correo;

//    @JsonProperty("Password")
    private String password;

//    @JsonProperty("RolId")
    private Long rolId;

//    @JsonProperty("EstadoId")
    private Long estadoId;
}