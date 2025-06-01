package com.acceleraite.mapper;

import com.acceleraite.dto.RolDTO;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Rol;
import com.acceleraite.entity.Usuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RolMapper {

    public static RolDTO mapToRolDTO(Rol rol){
        List<Long> usuariosIds = rol.getUsuarios()
                .stream()
                .map(Usuario::getId)
                .collect(Collectors.toList());

        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setNombre(rol.getNombre());
        rolDTO.setDescripcion(rol.getDescripcion());
        rolDTO.setFechaRegistro(rol.getFechaRegistro());
        rolDTO.setUsuariosIds(usuariosIds);
        rolDTO.setEstadoId(rol.getEstado().getId());
        return rolDTO;
    }

    public static Rol mapToRol(RolDTO rolDTO, List<Usuario> usuariosRelacionados){
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setNombre(rolDTO.getNombre());
        rol.setDescripcion(rolDTO.getDescripcion());
        rol.setFechaRegistro(LocalDateTime.now());
        rol.setUsuarios(usuariosRelacionados);

        if(rolDTO.getEstadoId() != null){
            Estado estado = new Estado();
            estado.setId(rolDTO.getEstadoId());
            rol.setEstado(estado);
        }
        return rol;
    }
}
