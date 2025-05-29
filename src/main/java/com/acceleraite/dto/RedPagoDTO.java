package com.acceleraite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RedPagoDTO {

    private Long Id;
    private String Nombre;
    private String Descripcion;
    private List<Long> PagosIds;
    private Long EstadoId;
}
