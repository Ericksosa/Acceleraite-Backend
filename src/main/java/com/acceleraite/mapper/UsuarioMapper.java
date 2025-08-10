package com.acceleraite.mapper;

import com.acceleraite.dto.UsuarioDTO;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Rol;
import com.acceleraite.entity.Usuario;



public class UsuarioMapper {

        public static UsuarioDTO mapToUsuarioDTO(Usuario usuario) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(usuario.getId());
            dto.setNombreUsuario(usuario.getNombreUsuario());
            dto.setCorreo(usuario.getCorreo());
            dto.setPassword(usuario.getPassword());

            if (usuario.getRol() != null) {
                dto.setRolId(usuario.getRol().getId());
                dto.setRolNombre(usuario.getRol().getNombre());
            }

            if (usuario.getEstado() != null) {
                dto.setEstadoId(usuario.getEstado().getId());
            }

            return dto;
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
