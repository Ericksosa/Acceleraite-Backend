package com.acceleraite.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class InspeccionDTO {

    private Long id;
    private Boolean tieneRalladuras;
    private Boolean tieneGomaRespuesta;
    private Boolean tieneGato;
    private Boolean tieneRoturaCristal;
    private Date fecha;
    private Long vehiculoId;
    private Long reservaId;
    private Long cantidadCombustibleId;
    private Long estadoGomaId;
    private Long empleadoId;
    private Long estadoId;
    private String estadoNombre;
    private String vehiculoNombre;
    private String ownerReservaName;
    private String empleadoNombre;


}
