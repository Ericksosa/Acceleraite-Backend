package com.acceleraite.service.impl;


import com.acceleraite.dto.EstadoDTO;
import com.acceleraite.entity.Estado;
import com.acceleraite.mapper.EstadoMapper;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.service.EstadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EstadoServiceImp implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


    @Override
    public List<EstadoDTO> getAllEstados(){
        List<Estado> estados = estadoRepository.findAll();
        return estados.stream()
                .map(EstadoMapper::toEstadoDTO)
                .collect(Collectors.toList());
    }
}
