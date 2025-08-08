package com.acceleraite.mapper;

import com.acceleraite.dto.EstadoDTO;
import com.acceleraite.entity.Estado;

public class EstadoMapper {

    public static EstadoDTO toEstadoDTO (Estado estado){
        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setId(estado.getId());
        estadoDTO.setNombre(estado.getNombre());
        estadoDTO.setDescripcion(estado.getDescripcion());
        return estadoDTO;
    }

    public static Estado toEstado (EstadoDTO estadoDTO){
        Estado estado = new Estado();
        estado.setId(estadoDTO.getId());
        estado.setNombre(estadoDTO.getNombre());
        estado.setDescripcion(estadoDTO.getDescripcion());
        return estado;
    }
}
