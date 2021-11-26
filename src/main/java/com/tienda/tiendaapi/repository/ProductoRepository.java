package com.tienda.tiendaapi.repository;

import com.tienda.tiendaapi.modelo.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {
}
