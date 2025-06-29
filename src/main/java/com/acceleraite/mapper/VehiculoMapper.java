package com.acceleraite.mapper;

//import com.acceleraite.dto.TipoCombustibleDTO;
import com.acceleraite.dto.VehiculoDTO;
import com.acceleraite.entity.*;

public class VehiculoMapper {
    public static VehiculoDTO toDTO(Vehiculo vehiculo) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(vehiculo.getId());
        dto.setDescripcion(vehiculo.getDescripcion());
        dto.setNoChasis(vehiculo.getNoChasis());
        dto.setNoMotor(vehiculo.getNoMotor());
        dto.setNoPlaca(vehiculo.getNoPlaca());
        dto.setColor(vehiculo.getColor());
        dto.setTipoCombustibleId(vehiculo.getTipoCombustible() != null ? vehiculo.getTipoCombustible().getId() : null);
        dto.setModeloId(vehiculo.getModelo() != null ? vehiculo.getModelo().getId() : null);
        dto.setTipoVehiculoId(vehiculo.getTipoVehiculo() != null ? vehiculo.getTipoVehiculo().getId() : null);
        dto.setEstadoId(vehiculo.getEstado() != null ? vehiculo.getEstado().getId() : null);
        return dto;
    }
    public static Vehiculo toEntity(VehiculoDTO dto){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(dto.getId());
        vehiculo.setDescripcion(dto.getDescripcion());
        vehiculo.setNoChasis(dto.getNoChasis());
        vehiculo.setNoMotor(dto.getNoMotor());
        vehiculo.setNoPlaca(dto.getNoPlaca());
        vehiculo.setColor(dto.getColor());

        if (dto.getTipoCombustibleId() != null) {
            TipoCombustible tc = new TipoCombustible();
            tc.setId(dto.getTipoCombustibleId());
            vehiculo.setTipoCombustible(tc);
        }

        if (dto.getModeloId() != null) {
            Modelo m = new Modelo();
            m.setId(dto.getModeloId());
            vehiculo.setModelo(m);
        }

        if (dto.getTipoVehiculoId() != null) {
            TipoVehiculo tv = new TipoVehiculo();
            tv.setId(dto.getTipoVehiculoId());
            vehiculo.setTipoVehiculo(tv);
        }

        if (dto.getEstadoId() != null) {
            Estado e = new Estado();
            e.setId(dto.getEstadoId());
            vehiculo.setEstado(e);
        }

        return vehiculo;
    }
}
