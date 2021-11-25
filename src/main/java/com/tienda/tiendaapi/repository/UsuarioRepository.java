package com.tienda.tiendaapi.repository;

import com.tienda.tiendaapi.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {

    @Query(value = "{correo_electronico:?:0,clave:?1}")
    List<Usuario> validadarConUsuarioYClave(String email, String password);
}