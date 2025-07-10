package com.acceleraite.service;

import com.acceleraite.dto.MarcaDTO;

import java.util.List;

public interface MarcaService {
    //Create
    MarcaDTO createMarca(MarcaDTO marcaDTO);
    //Get
    List<MarcaDTO> getAllMarcas();
    //Get By Id
    MarcaDTO getMarcaById(Long id);
    //Update
    MarcaDTO updateMarcaById(Long id, MarcaDTO updateMarca);
    //Delete
    void deleteMarca(Long marcaId, Long estadoId);
}
