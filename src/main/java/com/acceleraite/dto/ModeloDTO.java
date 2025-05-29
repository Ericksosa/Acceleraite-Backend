package com.acceleraite.dto;

import com.acceleraite.entity.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModeloDTO {

    private Long Id;
    private String Nombre;
    private String Descripcion;
    private Long MarcaId;
    private Long EstadoId;

}
