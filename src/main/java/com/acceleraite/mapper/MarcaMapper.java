package com.acceleraite.mapper;

import com.acceleraite.dto.MarcaDTO;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Marca;

public class MarcaMapper {
    public static MarcaDTO toDTO(Marca marca){
        MarcaDTO dto = new MarcaDTO();
        dto.setId(marca.getId());
        dto.setNombre(marca.getNombre());
        dto.setDescripcion(marca.getDescripcion());
        dto.setEstadoId(marca.getEstado() != null ? marca.getEstado().getId() : null);
        return dto;
    }
    public static Marca toEntity(MarcaDTO dto){
        Marca marca = new Marca();
        marca.setId(dto.getId());
        marca.setNombre(dto.getNombre());
        marca.setDescripcion(dto.getDescripcion());

        if (dto.getEstadoId() != null) {
            Estado estado = new Estado();
            estado.setId(dto.getEstadoId());
            marca.setEstado(estado);
        }

        return marca;
    }
}
