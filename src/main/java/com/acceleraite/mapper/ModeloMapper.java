package com.acceleraite.mapper;

import com.acceleraite.dto.ModeloDTO;
import com.acceleraite.entity.Modelo;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Marca;


public class ModeloMapper {
    public static ModeloDTO toDTO(Modelo modelo){
        ModeloDTO dto = new ModeloDTO();
        dto.setId(modelo.getId());
        dto.setNombre(modelo.getNombre());
        dto.setDescripcion(modelo.getDescripcion());
        dto.setMarcaId(modelo.getMarca() != null ? modelo.getMarca().getId() : null);
        dto.setEstadoId(modelo.getEstado() != null ? modelo.getEstado().getId() : null);
        return dto;
    }
    public static Modelo toEntity(ModeloDTO dto){
        Modelo modelo = new Modelo();
        if (dto.getId() != null) {
            modelo.setId(dto.getId());
        }
        modelo.setNombre(dto.getNombre());
        modelo.setDescripcion(dto.getDescripcion());

        //Marca
        if (dto.getMarcaId() != null) {
            Marca marca = new Marca();
            marca.setId(dto.getMarcaId());
            modelo.setMarca(marca);
        }

        //Estado
        if (dto.getEstadoId() != null) {
            Estado estado = new Estado();
            estado.setId(dto.getEstadoId());
            modelo.setEstado(estado);
        } else {
            modelo.setEstado(null);
        }

        return modelo;
    }
}
