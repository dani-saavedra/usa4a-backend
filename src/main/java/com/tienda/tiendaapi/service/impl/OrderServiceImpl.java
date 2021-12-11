package com.tienda.tiendaapi.service.impl;


import com.tienda.tiendaapi.dto.OrderDTO;
import com.tienda.tiendaapi.dto.ProductoDTO;
import com.tienda.tiendaapi.modelo.CleaningProduct;
import com.tienda.tiendaapi.modelo.Order;
import com.tienda.tiendaapi.repository.OrderRepository;
import com.tienda.tiendaapi.repository.ProductoRepository;
import com.tienda.tiendaapi.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductoRepository productoRepository;

    @Override
    public Boolean registrarNuevoPedido(OrderDTO dto) {
        int total = 0;
        Order nuevaOrder = new Order();
        nuevaOrder.setRegisterDay(new Date());
        nuevaOrder.setStatus(Order.PENDING);

        HashMap<String, Integer> quantities = new HashMap<>();
        HashMap<String, CleaningProduct> cleaningProducts = new HashMap<>();

        for (ProductoDTO product : dto.getProductos()) {
            quantities.put(product.getReferencia(), product.getCantidad());
            CleaningProduct cleaningProduct = productoRepository.findByReference(product.getReferencia());
            if(cleaningProduct.getCantidad() < product.getCantidad()){
                throw new IllegalArgumentException("Cantidad solicitada no disponible");
            }
            cleaningProduct.setCantidad(cleaningProduct.getCantidad() - product.getCantidad());
            productoRepository.save(cleaningProduct);
            cleaningProducts.put(product.getReferencia(), cleaningProduct);
            total = total + (cleaningProduct.getPrecio() * product.getCantidad());
        }
        nuevaOrder.setTotal(total);
        nuevaOrder.setQuantities(quantities);
        nuevaOrder.setProducts(cleaningProducts);
        nuevaOrder.setCliente(dto.getCliente());
        orderRepository.save(nuevaOrder);
        return true;
    }
}