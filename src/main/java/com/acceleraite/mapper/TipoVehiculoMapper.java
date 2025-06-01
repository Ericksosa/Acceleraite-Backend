package com.acceleraite.mapper;

import com.acceleraite.dto.TipoVehiculoDTO;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.TipoVehiculo;

public class TipoVehiculoMapper {

    public static TipoVehiculoDTO mapToTipoVehiculoDTO(TipoVehiculo tipoVehiculo){
        TipoVehiculoDTO tipoVehiculoDTO = new TipoVehiculoDTO();
        tipoVehiculoDTO.setId(tipoVehiculo.getId());
        tipoVehiculoDTO.setNombre(tipoVehiculo.getNombre());
        tipoVehiculoDTO.setDescripcion(tipoVehiculo.getDescripcion());
        tipoVehiculoDTO.setEstadoId(tipoVehiculo.getEstado().getId());
        return tipoVehiculoDTO;
    }

    public static TipoVehiculo mapToTipoVehiculo (TipoVehiculoDTO tipoVehiculoDTO){
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        tipoVehiculo.setId(tipoVehiculoDTO.getId());
        tipoVehiculo.setNombre(tipoVehiculoDTO.getNombre());
        tipoVehiculo.setDescripcion(tipoVehiculoDTO.getDescripcion());

        if(tipoVehiculoDTO.getEstadoId() != null){
            Estado estado = new Estado();
            estado.setId(tipoVehiculoDTO.getEstadoId());
            tipoVehiculo.setEstado(estado);
        }
        return tipoVehiculo;
    }
}
