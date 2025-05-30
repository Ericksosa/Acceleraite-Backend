package com.acceleraite.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class RolDTO {

    private Long Id;
    private String Nombre;
    private LocalDateTime FechaRegistro; // Posible cambio a Tipo DATE
    private String Descripcion;
    private List<Long> UsuariosIds;
    private Long EstadoId;
}
