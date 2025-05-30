package com.acceleraite.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class InspeccionDTO {

    private Long Id;
    private Boolean TieneRalladuras;
    private Boolean TieneGomaRespuesta;
    private Boolean TieneGato;
    private Boolean TieneRoturaCristal;
    private Date Fecha;
    private List<Long> PenalizacionesIds;
    private Long VehiculoId;
    private Long ReservaId;
    private Long CantidadCombustibleId;
    private Long EstadoGomaId;
    private Long EmpleadoId;
    private Long EstadoId;

}
