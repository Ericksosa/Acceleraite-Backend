package com.acceleraite.service;

import com.acceleraite.dto.EmpleadoDTO;

import java.util.List;

public interface EmpleadoService {

    //Create
    EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO);
    //Get
    List<EmpleadoDTO> getAllEmpleados();
    //Get By Id
    EmpleadoDTO getEmpleadoById(Long Id);
    //Update
    EmpleadoDTO updateEmpleadoById(Long Id, EmpleadoDTO updateEmpleado);
    //Delete
    void deleteEmpleado(Long empleadoId, Long statusID);
}
