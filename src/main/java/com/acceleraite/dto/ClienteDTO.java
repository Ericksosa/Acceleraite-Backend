package com.acceleraite.dto;

import com.acceleraite.entity.Calificacion;
import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long Id;
    private String Nombre;
    private String Apellido;
    private Long TarjetaCR;
    private Double LimiteCredito;
    private String TipoPersona;
    private List<Long> CalificacionesIds;
    private List<Long> OpinionesIds;
    private Long UsuarioId;
    private Long EstadoId;


}
