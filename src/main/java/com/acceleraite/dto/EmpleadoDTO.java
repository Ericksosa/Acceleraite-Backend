package com.acceleraite.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class EmpleadoDTO {

    private Long Id;
    private String Nombre;
    private String Apellido;
    private String Cedula;
    private String TandaLabor;
    private Double PorcientoComision;
    private Date FechaIngreso;
    private List<Long> ReservasIds;
    private List<Long> InspeccionIds;
    private Long UsuarioId;
    private Long EstadoId;
}
