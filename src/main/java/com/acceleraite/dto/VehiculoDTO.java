package com.acceleraite.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class VehiculoDTO {

    private long id;
    private String descripcion;
    private String noChasis;
    private String noMotor;
    private String noPlaca;
    private String color;
    private Double montoPorDia;
    private List<MultimediaDTO> multimedia = new ArrayList<>();
    private List<Long> calificacionesIds;
    private List<Long> opinionesIds;
    private List<Long> reservasIds;
    private Long inspeccionId;
    private Long tipoCombustibleId;
    private Long modeloId;
    private Long tipoVehiculoId;
    private Long estadoId;
    private String nombreMarca;
    private String url; // <--- nue
}
