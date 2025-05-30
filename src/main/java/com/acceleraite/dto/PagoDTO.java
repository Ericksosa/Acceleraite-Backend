package com.acceleraite.dto;

import lombok.*;

import java.util.Date;


@Data
public class PagoDTO {

    private Long Id;
    private String MontoAPagar;
    private Long NoTarjeta;
    private Date FechaVencimientoTarjeta;
    private int CVV;
    private String OwnerNombreTarjeta;
    private Long RedPagoId;
    private Long ReservaId;
    private Long EstadoId;

}
