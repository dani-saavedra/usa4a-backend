package com.tienda.tiendaapi.controller;


import com.tienda.tiendaapi.dto.ActualizarOrderDTO;
import com.tienda.tiendaapi.dto.OrderDTO;
import com.tienda.tiendaapi.modelo.Order;
import com.tienda.tiendaapi.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@AllArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping(path = "/new")
    @ResponseBody
    public ResponseEntity registrarNuevaOrden(@RequestBody OrderDTO dto) {
        try {

            service.registrarNuevoPedido(dto);
            return new ResponseEntity<>("Pedido registrado", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{order}")
    public ResponseEntity consultaOrden(@PathVariable Long order) {
        Order modeloOrder = service.consultarPorNumeroOrder(order);
        if (modeloOrder == null) {
            return new ResponseEntity("", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(modeloOrder, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/all")
    public List<Order> consultarTodasOrdenes() {
        return service.consultarTodos();
    }

    @PutMapping(path = "/update")
    public String aprobarOrder(@RequestBody ActualizarOrderDTO dto) {
        service.aprobarOrder(dto);
        return"ok";
    }
}


