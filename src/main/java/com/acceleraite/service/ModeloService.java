package com.acceleraite.service;

import com.acceleraite.dto.ModeloDTO;

import java.util.List;

public interface ModeloService {
    //Create
    ModeloDTO createModelo(ModeloDTO modeloDTO);
    //Get
    List<ModeloDTO> getAllModelos();
    //Get By Id
    ModeloDTO getModeloById(Long Id);
    //Update
    ModeloDTO updateModeloById(Long Id, ModeloDTO updateModelo);
    //Delete
    void deleteModelo(Long modeloId, Long statusID);
}
