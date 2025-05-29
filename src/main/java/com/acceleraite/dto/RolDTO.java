package com.acceleraite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolDTO {

    private Long Id;
    private String Nombre;
    private Date FechaRegistro;
    private String Descripcion;
    private List<Long> UsuariosIds;

}
