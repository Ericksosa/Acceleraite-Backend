package com.acceleraite.dto;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentaDTO {

    private Long Id;
    private String Descripcion;
    private Date FechaInicio;
    private Date FechaVencimiento;
    private Long MillajeInicio;
    private Long ReservaId;
    private Long EstadoId;


}
