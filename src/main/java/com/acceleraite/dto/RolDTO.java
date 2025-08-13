package com.acceleraite.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
public class RolDTO {

    private Long id;
    private String nombre;
    private LocalDate fechaRegistro;
    private String descripcion;
    private List<Long> usuariosIds;
    private Long estadoId;
    private String estadoNombre;

}
