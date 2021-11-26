package com.tienda.tiendaapi.dto;

import com.tienda.tiendaapi.enums.SINOEnum;
import com.tienda.tiendaapi.modelo.Producto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductoDTO implements Serializable {

    private String referencia;
    private String marca;
    private String materiales;
    private String categoria;
    private String descripcion;
    private SINOEnum disponibilidad;
    private Integer precio;
    private Integer cantidad;
    private String urlFotografia;

    public static ProductoDTO convertDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setCantidad(producto.getCantidad());
        productoDTO.setCategoria(productoDTO.getCategoria());
        productoDTO.setDescripcion(productoDTO.getDescripcion());
        productoDTO.setMarca(productoDTO.getMarca());
        productoDTO.setPrecio(productoDTO.getPrecio());
        productoDTO.setReferencia(productoDTO.getReferencia());
        productoDTO.setMateriales(productoDTO.getMateriales());
        return productoDTO;
    }
}
