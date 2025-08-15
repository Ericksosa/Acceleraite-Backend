package com.acceleraite.service;

import com.acceleraite.dto.CalificacionDTO;

import java.util.List;

public interface CalificacionService {

    List<CalificacionDTO> findAll();

    CalificacionDTO findById(Long id);

    CalificacionDTO create(CalificacionDTO dto);

    CalificacionDTO update(Long id, CalificacionDTO dto);

    void delete(Long id);

}
