package com.acceleraite.service.impl;


import com.acceleraite.dto.ReservaDTO;
import com.acceleraite.entity.Reserva;
import com.acceleraite.mapper.ReservaMapper;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.repository.ReservaRepository;
import com.acceleraite.service.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public ReservaDTO createReserva(ReservaDTO reservaDTO) {
        Reserva reserva = ReservaMapper.toEntity(reservaDTO);
        if(reservaDTO.getEstadoId() != null){
            reserva.setEstado(estadoRepository.findById(reservaDTO.getEstadoId()).orElseThrow(() -> new ResolutionException("No existe ningún estado como el ID: " + reservaDTO.getEstadoId())));
        } else{
            reserva.setEstado(null);
        }
        Reserva savedReserva = reservaRepository.save(reserva);
        return ReservaMapper.toDTO(savedReserva);
    }

    @Override
    public List<ReservaDTO> getAllReservas() {
        List<Reserva> reservas = reservaRepository.findByEstado_Id(1L);
        //Asumiendo que 1 es el ID del estado activo
        return reservas.stream()
                .map(ReservaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaDTO getReservaById(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new ResolutionException("No existe ninguna reserva con el ID: " + id));
        return ReservaMapper.toDTO(reserva);
    }

    @Override
    public ReservaDTO updateReservaById(Long id, ReservaDTO updateReserva) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new ResolutionException("No existe ningún empleado con el ID: " + id));
        reserva.setFechaCreacion(updateReserva.getFechaCreacion());
        reserva.setFechaInicio(updateReserva.getFechaInicio());
        reserva.setMonto_X_Dia(updateReserva.getMonto_X_Dia());
        reserva.setCantidadDia(updateReserva.getCantidadDia());
        reserva.setComentario(updateReserva.getComentario());
        reserva.setMontoTotal(updateReserva.getMontoTotal());
        if(updateReserva.getEstadoId() != null){
            reserva.setEstado((estadoRepository.findById(updateReserva.getEstadoId()).orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + updateReserva.getEstadoId()))));
        }
        else{
            reserva.setEstado(null);
        }

        Reserva updatedReserva = reservaRepository.save(reserva);
        return ReservaMapper.toDTO(updatedReserva);
    }


    @Override
    public void deleteReserva(Long reservaId, Long statusId) {
        Reserva reserva = reservaRepository.findById(reservaId).orElseThrow(() -> new ResolutionException("No existe ninguna reserva con el ID: " +reservaId));

        //Cambiar el estado del empleado
        if(statusId != null){
            reserva.setEstado(estadoRepository.findById(statusId).orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " +statusId)));
        }
        reservaRepository.save(reserva);
    }
}
