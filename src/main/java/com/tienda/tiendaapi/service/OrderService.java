package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.dto.OrderDTO;

public interface OrderService {

    Boolean  registrarNuevoPedido(OrderDTO dto);
}
