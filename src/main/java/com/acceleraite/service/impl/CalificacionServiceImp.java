package com.acceleraite.service.impl;

import com.acceleraite.dto.CalificacionDTO;
import com.acceleraite.entity.Calificacion;
import com.acceleraite.entity.Estado;
import com.acceleraite.exception.ResourceNotFoundException;
import com.acceleraite.mapper.CalificacionMapper;
import com.acceleraite.repository.CalificacionRepository;
import com.acceleraite.service.CalificacionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalificacionServiceImp implements CalificacionService {

    @Autowired
    private final CalificacionRepository repository;


    @Override
    public List<CalificacionDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(CalificacionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CalificacionDTO findById(Long id) {
        Calificacion entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calificacion" + "id" + id));
        return CalificacionMapper.toDto(entidad);
    }

    @Override
    public CalificacionDTO create(CalificacionDTO dto) {
        Calificacion entidad = CalificacionMapper.toEntity(dto);
        Calificacion guardada = repository.save(entidad);
        return CalificacionMapper.toDto(guardada);
    }

    @Override
    public CalificacionDTO update(Long id, CalificacionDTO dto) {
        Calificacion existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calificacion" + "id" + id));

        existente.setPuntuacion(dto.getPuntuacion());
        existente.setFecha(dto.getFecha()
                .toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate());
        Calificacion actualizada = repository.save(existente);
        return CalificacionMapper.toDto(actualizada);
    }

    @Override
    public void delete(Long id) {
        // 1. Buscar la entidad existente
        Calificacion existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calificacion" + "id" + id));

        // 2. Asignar el estado "2" (por ejemplo: "eliminado", "inactivo", etc.)
        Estado estadoEliminado = new Estado();
        estadoEliminado.setId(2L);
        existente.setEstado(estadoEliminado);

        // 3. Persistir el cambio
        repository.save(existente);
    }


}
