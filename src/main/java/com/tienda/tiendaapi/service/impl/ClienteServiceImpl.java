package com.tienda.tiendaapi.service.impl;

import com.tienda.tiendaapi.modelo.Cliente;
import com.tienda.tiendaapi.repository.ClienteRepository;
import com.tienda.tiendaapi.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public List<String> listarNombreCliente() {
        return repository.findAll()
        .stream().map(Cliente::getNombre)
        .collect(Collectors.toList());
    }
}
