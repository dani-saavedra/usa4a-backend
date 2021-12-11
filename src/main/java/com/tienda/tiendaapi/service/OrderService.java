package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.dto.OrderDTO;
import com.tienda.tiendaapi.modelo.Order;

public interface OrderService {

    Boolean  registrarNuevoPedido(OrderDTO dto);

    Order consultarPorNumeroOrder(Long numberOrder);
}
