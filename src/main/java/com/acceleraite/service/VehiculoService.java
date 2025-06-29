package com.acceleraite.service;

//import com.acceleraite.dto.EmpleadoDTO;
import com.acceleraite.dto.VehiculoDTO;

import java.util.List;

public interface VehiculoService {

    //Create
    VehiculoDTO createVehiculo(VehiculoDTO vehiculoDTO);
    //Get
    List<VehiculoDTO> getAllVehiculos();
    //Get By Id
    VehiculoDTO getVehiculoById(Long Id);
    //Update
    VehiculoDTO updateVehiculoById(Long Id, VehiculoDTO updateVehiculo);
    //Delete
    void deleteVehiculo(Long vehiculoId, Long statusID);
}
