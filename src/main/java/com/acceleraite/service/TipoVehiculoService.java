package com.acceleraite.service;

import com.acceleraite.dto.RolDTO;
import com.acceleraite.dto.TipoVehiculoDTO;

import java.util.List;

public interface TipoVehiculoService {

    // Create
    TipoVehiculoDTO createTipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO);

    // Get
    List<TipoVehiculoDTO> getAllTipoVehiculos();

    TipoVehiculoDTO getTipoVehiculoByID(Long tipoVehiculoId);

    // Update
    TipoVehiculoDTO updateTipoVehiculoById(Long tipoVehiculoId, TipoVehiculoDTO updateTipoVehiculo);

    //Delete
    void deleteTipoVehiculo(Long tipoVehiculoId, Long nuevoEstadoId);
}
