package com.tienda.tiendaapi.controller;


import com.tienda.tiendaapi.dto.GeneralResponse;
import com.tienda.tiendaapi.dto.OrderDTO;
import com.tienda.tiendaapi.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@AllArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping(path = "/new")
    public GeneralResponse registrarNuevaOrden(@RequestBody OrderDTO dto) {
        try {
            service.registrarNuevoPedido(dto);
            return new GeneralResponse("Pedido registrado");
        } catch (IllegalArgumentException e) {
            return new GeneralResponse(e.getMessage());
        }
    }
}
