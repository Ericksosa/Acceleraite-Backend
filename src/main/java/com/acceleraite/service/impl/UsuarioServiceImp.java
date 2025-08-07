package com.acceleraite.service.impl;

import com.acceleraite.dto.UsuarioDTO;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Rol;
import com.acceleraite.entity.Usuario;
import com.acceleraite.exception.ResourceNotFoundException;
import com.acceleraite.mapper.UsuarioMapper;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.repository.UsuarioRepository;
import com.acceleraite.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.mapToUsuario(usuarioDTO);

        // Asegúrate de cargar el Estado existente desde la base de datos
        Estado estado = estadoRepository.findById(usuarioDTO.getEstadoId())
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentra el estado con el ID: " + usuarioDTO.getEstadoId()));
        usuario.setEstado(estado);

        // Asignar el Rol (puedes validar con un repositorio también si deseas)
        Rol rol = new Rol();
        rol.setId(usuarioDTO.getRolId());
        usuario.setRol(rol);

        Usuario saveUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.mapToUsuarioDTO(saveUsuario);
    }

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().
                map(UsuarioMapper::mapToUsuarioDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO getUsuarioByID(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("No se pudo encontrar el usuario con el ID: " + usuarioId));
        return UsuarioMapper.mapToUsuarioDTO(usuario);
    }

    @Override
    public UsuarioDTO updateUsuarioById(Long usuarioId, UsuarioDTO updateUsuario) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("No se pudo encontrar el usuario con el ID: " + usuarioId));
        usuario.setId(updateUsuario.getId());
        usuario.setNombreUsuario(updateUsuario.getNombreUsuario());
        usuario.setCorreo(updateUsuario.getCorreo());
        usuario.setPassword(updateUsuario.getPassword());

        if(updateUsuario.getRolId() != null){
            Rol rol = new Rol();
            rol.setId(updateUsuario.getRolId());
            usuario.setRol(rol);
        }

        if(updateUsuario.getEstadoId() != null){
            Estado estado = new Estado();
            estado.setId(updateUsuario.getEstadoId());
            usuario.setEstado(estado);
        }
        Usuario actualizoUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.mapToUsuarioDTO(actualizoUsuario);
    }

    @Override
    public void deleteUsuario(Long UsuarioId, Long nuevoEstadoId) {
        Usuario usuario = usuarioRepository.findById(UsuarioId).
                orElseThrow(() -> new ResourceNotFoundException("No se encuentra el usuario con el ID: " + UsuarioId));

        Estado estado = estadoRepository.findById(nuevoEstadoId).
                orElseThrow(() -> new ResourceNotFoundException("No se encuentra el Estado con el ID: " + nuevoEstadoId));

        usuario.setEstado(estado);
        usuarioRepository.save(usuario);
    }
    @Override
    public UsuarioDTO login(String correo, String password) {
        Usuario usuario = usuarioRepository.findByEmailAndPassword(correo, password);
        if (usuario != null) {
            return UsuarioMapper.mapToUsuarioDTO(usuario);
        }
        return null;
    }

}
