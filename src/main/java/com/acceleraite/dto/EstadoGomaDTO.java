package com.acceleraite.dto;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EstadoGomaDTO {

    private Long Id;
    private String Nombre;
    private String Descripciom;
    private Long InspeccionId;

}
