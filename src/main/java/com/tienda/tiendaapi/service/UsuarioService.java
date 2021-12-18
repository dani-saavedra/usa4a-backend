package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.modelo.Usuario;

import java.util.List;

public interface UsuarioService {

    void guardar(String nombre, Long cedula);

    List<Usuario> obtenerUsuarios();

    List<Usuario> autenticar(String usuario, String clave);
}
