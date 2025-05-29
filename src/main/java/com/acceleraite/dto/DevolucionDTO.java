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
public class DevolucionDTO {

    private Long Id;
    private String Descripcion;
    private Date FechaDevolucion;
    private String EstadoObjeto;
    private Long InspeccionId;
    private Long EstadoId;
    private Long ReservaId;

}
