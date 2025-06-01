package com.acceleraite.service;

import com.acceleraite.dto.TipoCombustibleDTO;

import java.util.List;

public interface TipoCombustibleService {
    //Create
    TipoCombustibleDTO createTipoCombustible(TipoCombustibleDTO tipoCombustibleDTO);
    //Get by Id
    TipoCombustibleDTO getTipoCombustibleById(Long id);
    //Get All
    List<TipoCombustibleDTO> getAllTipoCombustibles();
    //Update
    TipoCombustibleDTO updateTipoCombustibleById(Long id, TipoCombustibleDTO tipoCombustibleDTO);
    //Delete
    void deleteTipoCombustible(Long id, Long estadoId);
}
