package com.acceleraite.service.impl;

import com.acceleraite.dto.TipoVehiculoDTO;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.TipoVehiculo;
import com.acceleraite.exception.ResourceNotFoundException;
import com.acceleraite.mapper.TipoVehiculoMapper;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.repository.TipoVehiculoRepository;
import com.acceleraite.service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoVehiculoServiceImp implements TipoVehiculoService {

    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public TipoVehiculoDTO createTipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO) {
        TipoVehiculo tipoVehiculo = TipoVehiculoMapper.mapToTipoVehiculo(tipoVehiculoDTO);
        TipoVehiculo saveTipoVehiculo = tipoVehiculoRepository.save(tipoVehiculo);
        return TipoVehiculoMapper.mapToTipoVehiculoDTO(saveTipoVehiculo);
    }

    @Override
    public List<TipoVehiculoDTO> getAllTipoVehiculos() {
        List<TipoVehiculo> tipoVehiculos = tipoVehiculoRepository.findAll();
        return tipoVehiculos.stream()
                .map(TipoVehiculoMapper::mapToTipoVehiculoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TipoVehiculoDTO getTipoVehiculoByID(Long tipoVehiculoId) {
        TipoVehiculo tipoVehiculo = tipoVehiculoRepository.findById(tipoVehiculoId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el Tipo de Vehiculo con el Id:" + tipoVehiculoId));

        return TipoVehiculoMapper.mapToTipoVehiculoDTO(tipoVehiculo);
    }

    @Override
    public TipoVehiculoDTO updateTipoVehiculoById(Long tipoVehiculoId, TipoVehiculoDTO updateTipoVehiculo) {

        TipoVehiculo tipoVehiculo = tipoVehiculoRepository.findById(tipoVehiculoId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el Tipo de Vehiculo con el ID: " + tipoVehiculoId));
        tipoVehiculo.setId(updateTipoVehiculo.getId());
        tipoVehiculo.setNombre(updateTipoVehiculo.getNombre());
        tipoVehiculo.setDescripcion(updateTipoVehiculo.getDescripcion());

        if(updateTipoVehiculo.getEstadoId() != null){
            Estado estado = new Estado();
            estado.setId(updateTipoVehiculo.getEstadoId());
            tipoVehiculo.setEstado(estado);
        }

        TipoVehiculo actualizadoTipoVehiculo = tipoVehiculoRepository.save(tipoVehiculo);
        return TipoVehiculoMapper.mapToTipoVehiculoDTO(actualizadoTipoVehiculo);
    }

    @Override
    public void deleteTipoVehiculo(Long tipoVehiculoId, Long nuevoEstadoId) {
        TipoVehiculo tipoVehiculo = tipoVehiculoRepository.findById(tipoVehiculoId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el Tipo de Vehiculo con este ID: " + tipoVehiculoId));

        Estado estado = estadoRepository.findById(nuevoEstadoId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontre el Estado mediante el ID: " + nuevoEstadoId));

        tipoVehiculo.setEstado(estado);
        tipoVehiculoRepository.save(tipoVehiculo);
    }

}
