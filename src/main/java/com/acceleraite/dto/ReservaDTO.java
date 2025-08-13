package com.acceleraite.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Data
public class ReservaDTO {

    private Long id;
    private LocalDate fechaCreacion;
    private LocalDate fechaInicio;
    private double monto_X_Dia;
    private double cantidadDia;
    private String comentario;
    private double montoTotal;
    private List<Long> PagoIds;
    private Long inspeccionId;
    private Long devolucionId;
    private List<Long> rentasIds;
    private Long empleadoId;
    private Long vehiculoId;
    private Long estadoId;
    private Long usuarioId;
    private Long penalizacionId;
    private List<Long> reservaServiciosIds;
    private String estadoNombre;
    private String reservaNombre;
    private String devolucionNombre;
    private String vehiculoNombre;

}
