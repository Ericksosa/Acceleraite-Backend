package com.acceleraite.mapper;

import com.acceleraite.dto.UsuarioDTO;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Rol;
import com.acceleraite.entity.Usuario;



public class UsuarioMapper {

    public static UsuarioDTO mapToUsuarioDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDTO.setCorreo(usuario.getCorreo());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setEstadoId(usuario.getEstado().getId());
        usuarioDTO.setRolId(usuario.getRol().getId());
        return usuarioDTO;
    }

    public static Usuario mapToUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setPassword(usuarioDTO.getPassword());

        if(usuarioDTO.getEstadoId() != null){
            Estado estado = new Estado();
            estado.setId(usuarioDTO.getEstadoId());
            usuario.setEstado(estado);
        }

        if(usuarioDTO.getRolId() != null){
            Rol rol = new Rol();
            rol.setId(usuarioDTO.getRolId());
            usuario.setRol(rol);
        }
        return usuario;

    }
}
