package com.acceleraite.dto;

import com.acceleraite.entity.CantidadCombustible;
import com.acceleraite.entity.Empleado;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.EstadoGoma;
import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InspeccionDTO {

    private Long Id;
    private Boolean TieneRalladuras;
    private Boolean TieneGomaRespuesta;
    private Boolean TieneGato;
    private Boolean TieneRoturaCristal;
    private Date Fecha;
    private List<Long> PenalizacionesIds;
    private Long VehiculoId;
    private Long ReservaId;
    private Long CantidadCombustibleId;
    private Long EstadoGomaId;
    private Long EmpleadoId;
    private Long EstadoId;

}
