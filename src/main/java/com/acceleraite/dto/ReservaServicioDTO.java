package com.acceleraite.dto;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaServicioDTO {

    private Long Id;
    private int Cantidad;
    private Long ReservaId;
    private Long ServicioId;

}
