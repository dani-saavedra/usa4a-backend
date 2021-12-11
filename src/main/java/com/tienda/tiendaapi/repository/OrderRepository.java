package com.tienda.tiendaapi.repository;


import com.tienda.tiendaapi.modelo.CleaningProduct;
import com.tienda.tiendaapi.modelo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrderRepository extends MongoRepository<Order,String> {


    @Query(value = "{numberOrder:?0}")
    Order findByNumberOrder(Long order);
}
