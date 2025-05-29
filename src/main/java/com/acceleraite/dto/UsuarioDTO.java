package com.acceleraite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long Id;
    private String NombreUsuario;
    private String Correo;
    private String Password;
    private List<Long> ReservasIds;
    private Long RolId;
}
