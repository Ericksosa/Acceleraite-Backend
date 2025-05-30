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
public class ReservaDTO {

    private Long Id;
    private Date FechaCreacion;
    private Date FechaInicio;
    private double Monto_X_Dia;
    private double CantidadDia;
    private String Comentario;
    private double MontoTotal;
    private List<Long> PagoIds;
    private Long InspeccionId;
    private Long DevolucionId;
    private List<Long> RentasIds;
    private Long EmpleadoId;
    private Long VehiculoId;
    private Long EstadoId;
    private Long UsuarioId;
    private Long PenalizacionId;
    private List<Long> reservaServiciosIds;


}
