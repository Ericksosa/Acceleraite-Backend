package com.acceleraite.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class EmpleadoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String tandaLabor;
    private Double porcientoComision;
    private Date fechaIngreso;
    private Long usuarioId;
    private String nombreUsuario;
    private Long estadoId;
    private String estadoNombre;
}
