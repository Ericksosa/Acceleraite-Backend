package com.acceleraite.dto;

import lombok.*;

import java.util.List;

@Data
public class VehiculoDTO {

    private long Id;
    private String Descripcion;
    private String NoChasis;
    private String NoMotor;
    private String NoPlaca;
    private String Color;
    private Double montoPorDia;
    private List<Long> MultimediaIds;
    private List<Long> CalificacionesIds;
    private List<Long> OpinionesIds;
    private List<Long> ReservasIds;
    private Long InspeccionId;
    private Long TipoCombustibleId;
    private Long ModeloId;
    private Long TipoVehiculoId;
    private Long EstadoId;

}
