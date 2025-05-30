package com.acceleraite.dto;

import lombok.*;


@Data
public class ReservaServicioDTO {

    private Long Id;
    private int Cantidad;
    private Long ReservaId;
    private Long ServicioId;

}
