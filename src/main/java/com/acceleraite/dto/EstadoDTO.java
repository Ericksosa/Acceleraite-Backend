package com.acceleraite.dto;

import lombok.*;

import java.util.List;


@Data
public class EstadoDTO {

    private Long Id;
    private String Nombre;
    private String Descripcion;
    private List<Long> EmpleadoIds;
    private List<Long> ClienteIds;
    private List<Long> ModeloIds;
    private List<Long> MarcaIds;
    private List<Long> TipoVehiculosIds;
    private List<Long> ReservaIds;
    private List<Long> RedPagosIds;
    private List<Long> PagosIds;
    private List<Long> metodoPagosIds;
    private List<Long> PenalizacionesIds;
    private List<Long> InspeccionesIds;
    private List<Long> MensajesLogsIds;
    private List<Long> RentasIds;

}
