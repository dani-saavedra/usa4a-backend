package com.tienda.tiendaapi.repository;

import com.tienda.tiendaapi.modelo.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    //db.productos.find({referencia:'x'})

    @Query(value = "{referencia:?0}")
    Producto findByReference(String referencia);
}
