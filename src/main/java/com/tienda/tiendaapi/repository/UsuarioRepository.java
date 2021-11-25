package com.tienda.tiendaapi.repository;

import com.tienda.tiendaapi.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {

    @Query(value = "{cedula:?0,nombre:?1}")
    List<Usuario> findByCedulaAndNombre(Integer cedula, String nombre);
}