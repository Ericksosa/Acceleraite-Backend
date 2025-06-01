package com.acceleraite.service.impl;

import com.acceleraite.dto.TipoCombustibleDTO;
import com.acceleraite.entity.TipoCombustible;
import com.acceleraite.mapper.TipoCombustibleMapper;
import com.acceleraite.repository.EmpleadoRepository;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.repository.TipoCombustibleRepository;
import com.acceleraite.service.TipoCombustibleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class TipoCombustibleServiceImpl implements TipoCombustibleService {
    @Autowired
    private TipoCombustibleRepository tipoCombustibleRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public TipoCombustibleDTO createTipoCombustible(TipoCombustibleDTO tipoCombustibleDTO) {
        TipoCombustible tipoCombustible = TipoCombustibleMapper.toEntity(tipoCombustibleDTO);
        if (tipoCombustibleDTO.getEstadoId() != null) {
            tipoCombustible.setEstado(estadoRepository.findById(tipoCombustibleDTO.getEstadoId())
                    .orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + tipoCombustibleDTO.getEstadoId())));
        } else {
            tipoCombustible.setEstado(null);
        }
        TipoCombustible savedTipoCombustible = tipoCombustibleRepository.save(tipoCombustible);
        return TipoCombustibleMapper.toDTO(savedTipoCombustible);
    }
    @Override
    public TipoCombustibleDTO getTipoCombustibleById(Long id) {
        TipoCombustible tipoCombustible = tipoCombustibleRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("No existe ningún tipo de combustible con el ID: " + id));
        return TipoCombustibleMapper.toDTO(tipoCombustible);
    }
    @Override
    public List<TipoCombustibleDTO> getAllTipoCombustibles() {
        List<TipoCombustible> tipoCombustibles = tipoCombustibleRepository.findByEstado_Id(1L); // Asumiendo que 1 es el ID del estado activo
        return tipoCombustibles.stream()
                .map(TipoCombustibleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TipoCombustibleDTO updateTipoCombustibleById(Long id, TipoCombustibleDTO tipoCombustibleDTO) {
        TipoCombustible tipoCombustible = tipoCombustibleRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("No existe ningún tipo de combustible con el ID: " + id));
        tipoCombustible.setNombre(tipoCombustibleDTO.getNombre());
        tipoCombustible.setDescripcion(tipoCombustibleDTO.getDescripcion());
        if (tipoCombustibleDTO.getEstadoId() != null) {
            tipoCombustible.setEstado(estadoRepository.findById(tipoCombustibleDTO.getEstadoId())
                    .orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + tipoCombustibleDTO.getEstadoId())));
        } else {
            tipoCombustible.setEstado(null);
        }
        TipoCombustible updatedTipoCombustible = tipoCombustibleRepository.save(tipoCombustible);
        return TipoCombustibleMapper.toDTO(updatedTipoCombustible);
    }
    @Override
    public void deleteTipoCombustible(Long id, Long estadoId) {
        TipoCombustible tipoCombustible = tipoCombustibleRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("No existe ningún tipo de combustible con el ID: " + id));
        if (estadoId != null) {
            tipoCombustible.setEstado(estadoRepository.findById(estadoId)
                    .orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + estadoId)));
        } else {
            tipoCombustible.setEstado(null);
        }
        tipoCombustibleRepository.save(tipoCombustible);
    }
}
