package com.tienda.tiendaapi.repository;


import com.tienda.tiendaapi.modelo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {

}
