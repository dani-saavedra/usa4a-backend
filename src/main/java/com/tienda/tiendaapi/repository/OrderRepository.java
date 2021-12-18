package com.tienda.tiendaapi.repository;


import com.tienda.tiendaapi.modelo.CleaningProduct;
import com.tienda.tiendaapi.modelo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {


    @Query(value = "{numberOrder:?0}")
    Order findByNumberOrder(Long order);

    @Query(value = "{vendedor:?0}")
    List<Order> consultarOrdenesPorVendedor(String idVendor);

    @Query(value = "{vendedor:?1,status:?0}")
    List<Order> consultarOrdenesPorVendedorYEstado(String estado, String vendor);
}
