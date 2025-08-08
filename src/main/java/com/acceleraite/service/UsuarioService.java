package com.acceleraite.service;

import com.acceleraite.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    // Create
    UsuarioDTO createUsuario(UsuarioDTO usuarioDTO);

    // Get
    List<UsuarioDTO> getAllUsuarios();

    UsuarioDTO getUsuarioByID(Long usuarioId);

    // Update
    UsuarioDTO updateUsuarioById(Long usuarioId, UsuarioDTO updateUsuario);

    //Delete
    void deleteUsuario(Long UsuarioId, Long nuevoEstadoId);

    UsuarioDTO login(String correo, String password);

}
