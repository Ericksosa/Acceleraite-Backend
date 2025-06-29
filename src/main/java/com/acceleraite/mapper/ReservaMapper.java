package com.acceleraite.mapper;

//import com.acceleraite.dto.EmpleadoDTO;
import com.acceleraite.dto.ReservaDTO;
//import com.acceleraite.entity.Empleado;
import com.acceleraite.entity.*;

public class ReservaMapper {
    public static ReservaDTO toDTO(Reserva reserva){
        ReservaDTO dto = new ReservaDTO();
        dto.setId(reserva.getId());
        dto.setFechaCreacion(reserva.getFechaCreacion());
        dto.setFechaInicio(reserva.getFechaInicio());
        dto.setMonto_X_Dia(reserva.getMonto_X_Dia());
        dto.setCantidadDia(reserva.getCantidadDia());
        dto.setComentario(reserva.getComentario());
        dto.setMontoTotal(reserva.getMontoTotal());
        dto.setInspeccionId(reserva.getInspeccion() != null ? reserva.getInspeccion().getId() : null);
        dto.setDevolucionId(reserva.getDevolucion() != null ? reserva.getDevolucion().getId() : null);
        dto.setEmpleadoId(reserva.getEmpleado() != null ? reserva.getEmpleado().getId() : null);
        dto.setVehiculoId(reserva.getVehiculo() != null ? reserva.getVehiculo().getId() : null);
        dto.setUsuarioId(reserva.getUsuario() != null ? reserva.getUsuario().getId() : null);
        dto.setPenalizacionId(reserva.getPenalizacion() != null ? reserva.getPenalizacion().getId() : null);
        dto.setEstadoId(reserva.getEstado() != null ? reserva.getEstado().getId() : null);
        return dto;
    }

    public static Reserva toEntity(ReservaDTO dto){
        Reserva reserva = new Reserva();
        reserva.setId(dto.getId());
        reserva.setFechaCreacion(dto.getFechaCreacion());
        reserva.setFechaInicio(dto.getFechaInicio());
        reserva.setMonto_X_Dia(dto.getMonto_X_Dia());
        reserva.setCantidadDia(dto.getCantidadDia());
        reserva.setComentario(dto.getComentario());
        reserva.setMontoTotal(dto.getMontoTotal());

        /// Empleado
        if(dto.getEmpleadoId() != null){
            Empleado empleado = new Empleado();
            empleado.setId(dto.getEmpleadoId());
            reserva.setEmpleado(empleado);
        } else{
            reserva.setEmpleado(null);
        }

        /// Vehiculo
        if(dto.getVehiculoId() != null){
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setId(dto.getVehiculoId());
            reserva.setVehiculo(vehiculo);
        } else{
            reserva.setVehiculo(null);
        }

        /// Estado
        if(dto.getEstadoId() != null){
            Estado estado = new Estado();
            estado.setId(dto.getEstadoId());
            reserva.setEstado(estado);
        } else{
            reserva.setEstado(null);
        }

        /// Usuario
        if(dto.getUsuarioId() != null){
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());
            reserva.setUsuario(usuario);
        } else{
            reserva.setUsuario(null);
        }

        /// Penalización
        if(dto.getPenalizacionId() != null){
            Penalizacion penalizacion = new Penalizacion();
            penalizacion.setId(dto.getPenalizacionId());
            reserva.setPenalizacion(penalizacion);
        } else{
            reserva.setPenalizacion(null);
        }

        return reserva;
    }
}
