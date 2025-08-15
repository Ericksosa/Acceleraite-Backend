package com.acceleraite.service;

//import com.acceleraite.dto.EmpleadoDTO;
import com.acceleraite.dto.MultimediaDTO;
import com.acceleraite.dto.VehiculoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    List<MultimediaDTO> agregarMultimedia(Long vehiculoId, List<MultipartFile> files, String tipo) throws IOException;

    List<VehiculoDTO> obtenerVehiculosConImagenes();
}

