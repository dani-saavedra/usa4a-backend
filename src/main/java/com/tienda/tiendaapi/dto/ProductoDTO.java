package com.tienda.tiendaapi.dto;

import com.tienda.tiendaapi.enums.MarcaEnum;
import com.tienda.tiendaapi.enums.SINOEnum;
import com.tienda.tiendaapi.modelo.Producto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductoDTO implements Serializable {

    private String referencia;
    private MarcaEnum marca;
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
        productoDTO.setCategoria(producto.getCategoria());
        productoDTO.setDescripcion(producto.getDescripcion());
        if(producto.getDisponibilidad() != null && producto.getDisponibilidad()){
            productoDTO.setDisponibilidad(SINOEnum.SI);
        }else{
            productoDTO.setDisponibilidad(SINOEnum.NO);
        }
        productoDTO.setMarca(MarcaEnum.valueOf(producto.getMarca()));// De string a enum
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setReferencia(producto.getReferencia());
        productoDTO.setMateriales(producto.getMateriales());
        return productoDTO;
    }
}
