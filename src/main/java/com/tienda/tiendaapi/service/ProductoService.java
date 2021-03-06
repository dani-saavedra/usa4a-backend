package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {

    void guardarNuevoProducto(ProductoDTO dto);

    List<ProductoDTO> obtenerProductos();

    void eliminarProducto(String referencia);

    void actualizarProducto(ProductoDTO dto);

    ProductoDTO consultarPorReferencia(String referencia);
}
