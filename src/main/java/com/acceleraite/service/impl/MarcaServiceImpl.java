package com.acceleraite.service.impl;

import com.acceleraite.dto.EmpleadoDTO;
import com.acceleraite.dto.MarcaDTO;
import com.acceleraite.entity.Empleado;
import com.acceleraite.entity.Marca;
import com.acceleraite.mapper.EmpleadoMapper;
import com.acceleraite.mapper.MarcaMapper;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.repository.MarcaRepository;
import com.acceleraite.service.MarcaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    // Implement the methods from MarcaService interface here
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    //GET
    @Override
    public List<MarcaDTO> getAllMarcas() {
        List<Marca> marcas = marcaRepository.findByEstado_Id(1L); // Asumiendo que 1 es el ID del estado activo
        return marcas.stream()
                .map(MarcaMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public MarcaDTO getMarcaById(Long marcaId) {
        Marca marca = marcaRepository.findById(marcaId)
                .orElseThrow(() -> new RuntimeException("No existe ninguna marca con el ID: " + marcaId));
        return MarcaMapper.toDTO(marca);
    }
    @Override
    public MarcaDTO createMarca(MarcaDTO marcaDTO) {
        Marca marca = MarcaMapper.toEntity(marcaDTO);
        if (marcaDTO.getEstadoId() != null) {
            marca.setEstado(estadoRepository.findById(marcaDTO.getEstadoId())
                    .orElseThrow(() -> new RuntimeException("No existe ningún estado con el ID: " + marcaDTO.getEstadoId())));
        } else {
            marca.setEstado(null);
        }
        Marca savedMarca = marcaRepository.save(marca);
        return MarcaMapper.toDTO(savedMarca);
    }
    @Override
    public MarcaDTO updateMarcaById(Long marcaId, MarcaDTO updateMarca) {
        Marca marca = marcaRepository.findById(marcaId)
                .orElseThrow(() -> new RuntimeException("No existe ninguna marca con el ID: " + marcaId));

        // Update fields
        marca.setNombre(updateMarca.getNombre());
        marca.setDescripcion(updateMarca.getDescripcion());

        if (updateMarca.getEstadoId() != null) {
            marca.setEstado(estadoRepository.findById(updateMarca.getEstadoId())
                    .orElseThrow(() -> new RuntimeException("No existe ningún estado con el ID: " + updateMarca.getEstadoId())));
        } else {
            marca.setEstado(null);
        }
        Marca updatedMarca = marcaRepository.save(marca);
        return MarcaMapper.toDTO(updatedMarca);
    }
    @Override
    public void deleteMarca(Long marcaId, Long estadoId) {
        Marca marca = marcaRepository.findById(marcaId)
                .orElseThrow(() -> new RuntimeException("No existe ninguna marca con el ID: " + marcaId));

        // Set the estado to null or a specific inactive state
        if (estadoId != null) {
            marca.setEstado(estadoRepository.findById(estadoId)
                    .orElseThrow(() -> new RuntimeException("No existe ningún estado con el ID: " + estadoId)));
        } else {
            marca.setEstado(null);
        }

        // Save the updated marca
        marcaRepository.save(marca);
    }
}
