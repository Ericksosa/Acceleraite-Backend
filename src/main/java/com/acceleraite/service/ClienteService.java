package com.acceleraite.service;

import com.acceleraite.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    // Create Cliente
    ClienteDTO createCliente (ClienteDTO clienteDTO);

    // Get one Cliente
    ClienteDTO getClienteById (Long Id);

    // Get All Clientes
    List<ClienteDTO> getAllClientes();

    //Update Cliente
    ClienteDTO updateClienteById (Long id, ClienteDTO updateCliente);

    // Delete Cliente
    void deleteCliente (Long id, Long estadoId);
}
