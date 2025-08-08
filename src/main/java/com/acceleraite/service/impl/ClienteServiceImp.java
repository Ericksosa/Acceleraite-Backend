package com.acceleraite.service.impl;

import com.acceleraite.dto.ClienteDTO;
import com.acceleraite.entity.Cliente;
import com.acceleraite.mapper.ClienteMapper;
import com.acceleraite.repository.ClienteRepository;
import com.acceleraite.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        return null;
    }

    @Override
    public ClienteDTO getClienteById(Long Id) {
        return null;
    }

    @Override
    public List<ClienteDTO> getAllClientes() {
        return List.of();
    }

    @Override
    public ClienteDTO updateClienteById(Long id, ClienteDTO updateCliente) {
        return null;
    }

    @Override
    public void deleteCliente(Long id, Long estadoId) {

    }
}
