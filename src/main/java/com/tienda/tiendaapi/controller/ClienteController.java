package com.tienda.tiendaapi.controller;


import com.tienda.tiendaapi.dto.ConsultaClienteDTO;
import com.tienda.tiendaapi.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
@AllArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping(path = "/obtenerlos")
    public ConsultaClienteDTO obtenerClientes() {
        List<String> clientes = clienteService.listarNombreCliente();
        ConsultaClienteDTO dto = new ConsultaClienteDTO();
        dto.setClientes(clientes);
        return dto;
    }
}
