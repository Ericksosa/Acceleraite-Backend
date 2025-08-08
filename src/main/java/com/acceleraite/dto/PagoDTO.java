package com.acceleraite.dto;

import lombok.*;

import java.util.Date;


@Data
public class PagoDTO {

    private Long id;
    private String montoAPagar;
    private Long noTarjeta;
    private Date fechaVencimientoTarjeta;
    private int CVV;
    private String ownerNombreTarjeta;
    private Long redPagoId;
    private Long reservaId;
    private Long estadoId;
    private String estadoNombre;

}
