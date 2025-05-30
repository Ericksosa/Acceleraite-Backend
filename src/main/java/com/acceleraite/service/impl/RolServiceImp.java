package com.acceleraite.service.impl;

import com.acceleraite.dto.RolDTO;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Rol;
import com.acceleraite.entity.Usuario;
import com.acceleraite.mapper.RolMapper;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.repository.RolRepository;
import com.acceleraite.repository.UsuarioRepository;
import com.acceleraite.service.RolService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RolServiceImp implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public RolDTO createRol(RolDTO rolDTO){
        List<Usuario> usuariosRelacionados = new ArrayList<>();

        if(rolDTO.getUsuariosIds() != null && !rolDTO.getUsuariosIds().isEmpty()){
            usuariosRelacionados = usuarioRepository.findAllById(rolDTO.getUsuariosIds());
        }

        Rol rol = RolMapper.mapToRol(rolDTO, usuariosRelacionados);
        Rol savedRol = rolRepository.save(rol);
        return RolMapper.mapToRolDTO(savedRol);
    }

    @Override
    public List<RolDTO> getAllRols() {
        List<Rol> rols = rolRepository.findAll();
        return rols.stream().map(RolMapper::mapToRolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RolDTO getRolByID(Long rolId) {
       Rol rol = rolRepository.findById(rolId)
               .orElseThrow(() -> new ResolutionException("No existe ningún rol con el ID: " + rolId));
       return RolMapper.mapToRolDTO(rol);
    }

    @Override
    public RolDTO updateRolById(Long rolId, RolDTO updateRol) {
        List<Usuario> usuariosRelacionados = new ArrayList<>();
        if(updateRol.getUsuariosIds() != null && !updateRol.getUsuariosIds().isEmpty()){
            usuariosRelacionados = usuarioRepository.findAllById(updateRol.getUsuariosIds());
        }

        Rol rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new ResolutionException("No se encontro el Rol con el ID: " + rolId));
        rol.setId(updateRol.getId());
        rol.setNombre(updateRol.getNombre());
        rol.setDescripcion(updateRol.getDescripcion());
        rol.setUsuarios(usuariosRelacionados);
        Rol actualizadoRolObj = rolRepository.save(rol);
        return RolMapper.mapToRolDTO(actualizadoRolObj);
    }

    @Override
    public void deleteRol(Long rolId, Long nuevoEstadoId) {
        Rol rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new ResolutionException("No se encontro el Rol con el ID: " + rolId));

        Estado nuevoEstado = estadoRepository.findById(nuevoEstadoId)
                .orElseThrow(() -> new ResolutionException("No se encontre el estado con el Id" + nuevoEstadoId));

        rol.setEstado(nuevoEstado);
        rolRepository.save(rol);
    }

}
