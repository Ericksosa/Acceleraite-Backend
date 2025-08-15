package com.acceleraite.mapper;

//import com.acceleraite.dto.TipoCombustibleDTO;
import com.acceleraite.dto.MultimediaDTO;
import com.acceleraite.dto.VehiculoDTO;
import com.acceleraite.entity.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

public class VehiculoMapper {
    public static VehiculoDTO toDTO(Vehiculo vehiculo) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(vehiculo.getId());
        dto.setDescripcion(vehiculo.getDescripcion());
        dto.setNoChasis(vehiculo.getNoChasis());
        dto.setNoMotor(vehiculo.getNoMotor());
        dto.setNoPlaca(vehiculo.getNoPlaca());
        dto.setColor(vehiculo.getColor());
        dto.setMontoPorDia(vehiculo.getMontoPorDia());
        dto.setTipoCombustibleId(vehiculo.getTipoCombustible() != null ? vehiculo.getTipoCombustible().getId() : null);
        dto.setModeloId(vehiculo.getModelo() != null ? vehiculo.getModelo().getId() : null);
        dto.setTipoVehiculoId(vehiculo.getTipoVehiculo() != null ? vehiculo.getTipoVehiculo().getId() : null);
        dto.setEstadoId(vehiculo.getEstado() != null ? vehiculo.getEstado().getId() : null);

        List<MultimediaDTO> media = vehiculo.getMultimedia().stream().map(m -> {
            MultimediaDTO mdto = new MultimediaDTO();
            mdto.setId(m.getId());
            mdto.setTipo(m.getTipo());
            mdto.setContentType(m.getContentType());
            mdto.setNombreArchivo(m.getNombreArchivo());
            mdto.setNombreArchivo(m.getNombreArchivo());
            String urlPrincipal = vehiculo.getMultimedia().isEmpty() ? null :
                    ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/api/multimedia/")
                            .path(String.valueOf(vehiculo.getMultimedia().get(0).getId()))
                            .path("/archivo")
                            .toUriString();

            mdto.setUrl(urlPrincipal);
            return mdto;
        }).toList();

        dto.setMultimedia(media);
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
        vehiculo.setMontoPorDia(dto.getMontoPorDia());

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
