package com.acceleraite.service.impl;


import com.acceleraite.dto.ModeloDTO;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Marca;
import com.acceleraite.entity.Modelo;
import com.acceleraite.mapper.ModeloMapper;
import com.acceleraite.repository.ModeloRepository;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.service.ModeloService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModeloServiceImpl implements ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public ModeloDTO createModelo(ModeloDTO modeloDTO){
        Modelo modelo = ModeloMapper.toEntity(modeloDTO);
        if (modeloDTO.getEstadoId() != null) {
            modelo.setEstado(estadoRepository.findById(modeloDTO.getEstadoId())
                    .orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + modeloDTO.getEstadoId())));
        } else {
            modelo.setEstado(null);
        }
        Modelo savedModelo = modeloRepository.save(modelo);
        return ModeloMapper.toDTO(savedModelo);
    }

    @Override
    public List<ModeloDTO> getAllModelos() {
        List<Modelo> modelos = modeloRepository.findByEstado_Id(1L); // Asumiendo que 1 es el ID del estado activo
        return modelos.stream()
                .map(ModeloMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ModeloDTO getModeloById(Long modeloId){
        Modelo modelo = modeloRepository.findById(modeloId)
                .orElseThrow(() -> new ResolutionException("No existe ningún modelo con el ID: " + modeloId));
        return ModeloMapper.toDTO(modelo);
    }

    @Override
    public ModeloDTO updateModeloById(Long modeloId, ModeloDTO updateModelo) {
        Modelo modelo = modeloRepository.findById(modeloId)
                .orElseThrow(() -> new ResolutionException("No existe ningún modelo con el ID: " + modeloId));

        modelo.setNombre(updateModelo.getNombre());
        modelo.setDescripcion(updateModelo.getDescripcion());

        if (updateModelo.getMarcaId() != null) {
            Marca marca = new Marca();
            marca.setId(updateModelo.getMarcaId());
            modelo.setMarca(marca);
        }

        if (updateModelo.getEstadoId() != null) {
            Estado estado = new Estado();
            estado.setId(updateModelo.getEstadoId());
            modelo.setEstado(estado);
        }

        Modelo updatedModelo = modeloRepository.save(modelo);
        return ModeloMapper.toDTO(updatedModelo);
    }

    @Override
    public void deleteModelo(Long modeloId, Long estadoId) {
        Modelo modelo = modeloRepository.findById(modeloId)
                .orElseThrow(() -> new ResolutionException("No existe ningún modelo con el ID: " + modeloId));

        // Cambiar el estado del modelo
        if (estadoId != null) {
            modelo.setEstado(estadoRepository.findById(estadoId)
                    .orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + estadoId)));
        }

        modeloRepository.save(modelo);
    }

}
