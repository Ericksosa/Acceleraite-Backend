package com.acceleraite.service;

import com.acceleraite.dto.EstadoDTO;

import java.util.List;

public interface EstadoService {

    List<EstadoDTO> getAllEstados();

    EstadoDTO getEstadoById(Long id);

}
