package com.acceleraite.service;

import com.acceleraite.dto.RolDTO;

import java.util.List;

public interface RolService {

    // Create
    RolDTO createRol(RolDTO rolDTO);

    // Get
    List<RolDTO> getAllRols();

    RolDTO getRolByID(Long rolId);

    // Update
    RolDTO updateRolById(Long rolId, RolDTO updateRol);

    //Delete
    void deleteRol(Long rolId);

}
