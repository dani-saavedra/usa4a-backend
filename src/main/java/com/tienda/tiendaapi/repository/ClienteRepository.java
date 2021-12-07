package com.tienda.tiendaapi.repository;

import com.tienda.tiendaapi.modelo.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}