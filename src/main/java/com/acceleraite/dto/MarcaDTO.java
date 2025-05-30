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
public class MarcaDTO {

    private long Id;
    private String Nombre;
    private String Descripcion;
    private List<Long> ModelosIds;
    private Long EstadoId;

}