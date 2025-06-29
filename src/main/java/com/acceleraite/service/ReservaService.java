package com.acceleraite.service;

import com.acceleraite.dto.ReservaDTO;

import java.util.List;

public interface ReservaService {
    //create
    ReservaDTO createReserva(ReservaDTO reservaDTO);
    //Get
    List<ReservaDTO> getAllReservas();
    //Get By ID
    ReservaDTO getReservaById(Long id);
    //Update
    ReservaDTO updateReservaById(Long id, ReservaDTO updateReserva);
    //Delete
    void deleteReserva(Long reservaId, Long statusId);
}
