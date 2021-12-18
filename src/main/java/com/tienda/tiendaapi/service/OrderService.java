package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.dto.ActualizarOrderDTO;
import com.tienda.tiendaapi.dto.OrderDTO;
import com.tienda.tiendaapi.modelo.Order;

import java.util.List;

public interface OrderService {

    Boolean registrarNuevoPedido(OrderDTO dto);

    Order consultarPorNumeroOrder(Long numberOrder);

    List<Order> consultarTodos();

    List<Order> consultarOrdenesPorVendedor(String vendedor);

    List<Order> consultarOrdenesPorEstadoyVendedor(String estado, String vendedor);

    void aprobarOrder(ActualizarOrderDTO dto);
}
