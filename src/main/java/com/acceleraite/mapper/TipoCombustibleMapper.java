package com.acceleraite.mapper;

import com.acceleraite.dto.TipoCombustibleDTO;
import com.acceleraite.entity.TipoCombustible;
import com.acceleraite.entity.Estado;

public class TipoCombustibleMapper {
    public static TipoCombustibleDTO toDTO(TipoCombustible tipoCombustible) {
        TipoCombustibleDTO dto = new TipoCombustibleDTO();
        dto.setId(tipoCombustible.getId());
        dto.setNombre(tipoCombustible.getNombre());
        dto.setDescripcion(tipoCombustible.getDescripcion());
        dto.setEstadoId(tipoCombustible.getEstado() != null ? tipoCombustible.getEstado().getId() : null);
        dto.setEstadoNombre(tipoCombustible.getEstado().getNombre());
        return dto;
    }
    public static TipoCombustible toEntity(TipoCombustibleDTO dto){
        TipoCombustible tipoCombustible = new TipoCombustible();
        tipoCombustible.setId(dto.getId());
        tipoCombustible.setNombre(dto.getNombre());
        tipoCombustible.setDescripcion(dto.getDescripcion());
        if (dto.getEstadoId() != null) {
            Estado estado = new Estado();
            estado.setId(dto.getEstadoId());
            tipoCombustible.setEstado(estado);
        } else {
            tipoCombustible.setEstado(null);
        }
        return tipoCombustible;
    }
}