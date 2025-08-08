package com.acceleraite.mapper;

import com.acceleraite.dto.ClienteDTO;
import com.acceleraite.entity.Cliente;
import com.acceleraite.entity.Estado;
import com.acceleraite.entity.Usuario;

public class ClienteMapper {

    public static ClienteDTO toClienteDTO (Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setTarjetaCR(cliente.getTarjetaCR());
        clienteDTO.setLimiteCredito(cliente.getLimiteCredito());
        clienteDTO.setTipoPersona(cliente.getTipoPersona());
        clienteDTO.setEstadoId(cliente.getEstado() != null ? cliente.getEstado().getId() : null);
        clienteDTO.setUsuarioId(cliente.getUsuario() != null ? cliente.getUsuario().getId() : null);
        return clienteDTO;
    }

    public static Cliente toCliente (ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setTarjetaCR(clienteDTO.getTarjetaCR());
        cliente.setLimiteCredito(clienteDTO.getLimiteCredito());
        cliente.setTipoPersona(clienteDTO.getTipoPersona());

        if(clienteDTO.getUsuarioId() != null){
            Usuario usuario = new Usuario();
            usuario.setId(cliente.getId());
            cliente.setUsuario(usuario);
        }
        if(clienteDTO.getEstadoId() != null){
            Estado estado = new Estado();
            estado.setId(clienteDTO.getEstadoId());
            cliente.setEstado(estado);
        }

        return cliente;
    }

}
