package com.tienda.tiendaapi.service.impl;

import com.tienda.tiendaapi.modelo.Usuario;
import com.tienda.tiendaapi.repository.UsuarioRepository;
import com.tienda.tiendaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository userRepository;
    private final MongoTemplate mongoTemplate;

    public UsuarioServiceImpl(UsuarioRepository userRepository, MongoTemplate mongoTemplate) {
        this.userRepository = userRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void guardar(String nombre, Long cedula) {
        Usuario entidadUsuario = new Usuario();
        entidadUsuario.setNombre(nombre);
        entidadUsuario.setCedula(cedula);
        userRepository.save(entidadUsuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public Boolean autenticar(String usuario, String clave) {
        List<Usuario> listUsuario = userRepository.validadarConUsuarioYClave(usuario, clave);
        return !listUsuario.isEmpty();
    }
}