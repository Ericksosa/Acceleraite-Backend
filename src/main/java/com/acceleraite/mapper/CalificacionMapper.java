package com.acceleraite.mapper;

import com.acceleraite.dto.CalificacionDTO;
import com.acceleraite.entity.Calificacion;
import com.acceleraite.entity.Cliente;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Vehiculo;

import java.time.ZoneId;
import java.util.Date;

public class CalificacionMapper {

    public static CalificacionDTO toDto(Calificacion entidad) {
        if (entidad == null) {
            return null;
        }
        CalificacionDTO dto = new CalificacionDTO();
        dto.setId(entidad.getId());
        dto.setPuntuacion(entidad.getPuntuacion());
        dto.setFecha(Date.from(
                entidad.getFecha()
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()));

        if (entidad.getCliente() != null) {
            dto.setClienteId(entidad.getCliente().getId());
        }
        if (entidad.getVehiculo() != null) {
            dto.setVehiculoId(entidad.getVehiculo().getId());
        }
        if (entidad.getEstado() != null) {
            dto.setEstadoId(entidad.getEstado().getId());
            dto.setEstadoNombre(entidad.getEstado().getNombre());
        }
        return dto;
    }

    public static Calificacion toEntity(CalificacionDTO dto) {
        if (dto == null) {
            return null;
        }
        Calificacion entidad = new Calificacion();
        entidad.setId(dto.getId());
        entidad.setPuntuacion(dto.getPuntuacion());
        entidad.setFecha(dto.getFecha()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());

        if (dto.getClienteId() != null) {
            Cliente c = new Cliente();
            c.setId(dto.getClienteId());
            entidad.setCliente(c);
        }
        if (dto.getVehiculoId() != null) {
            Vehiculo v = new Vehiculo();
            v.setId(dto.getVehiculoId());
            entidad.setVehiculo(v);
        }
        if (dto.getEstadoId() != null) {
            Estado e = new Estado();
            e.setId(dto.getEstadoId());
            entidad.setEstado(e);
        }
        return entidad;
    }
}
