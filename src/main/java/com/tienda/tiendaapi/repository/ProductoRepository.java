package com.tienda.tiendaapi.repository;

import com.tienda.tiendaapi.modelo.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductoRepository extends MongoRepository<CleaningProduct, String> {
    //db.productos.find({referencia:'x'})

    @Query(value = "{referencia:?0}")
    CleaningProduct findByReference(String referencia);
}
