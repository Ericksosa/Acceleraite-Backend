package com.acceleraite.dto;

import lombok.*;


@Data
public class ReservaServicioDTO {

    private Long id;
    private int cantidad;
    private Long reservaId;
    private Long servicioId;

}
