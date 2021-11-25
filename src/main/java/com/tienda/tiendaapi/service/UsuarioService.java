package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.modelo.Usuario;

import java.util.List;

public interface UsuarioService {

    void guardar(String nombre, Long cedula);

    List<Usuario> obtenerUsuarios();

    Boolean autenticar(String usuario, String clave);
}
