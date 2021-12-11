package com.tienda.tiendaapi.dto;

import com.tienda.tiendaapi.enums.MarcaEnum;
import com.tienda.tiendaapi.enums.SINOEnum;
import com.tienda.tiendaapi.modelo.CleaningProduct;
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

    public static ProductoDTO convertDTO(CleaningProduct cleaningProduct) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setCantidad(cleaningProduct.getCantidad());
        productoDTO.setCategoria(cleaningProduct.getCategoria());
        productoDTO.setDescripcion(cleaningProduct.getDescripcion());
        if(cleaningProduct.getDisponibilidad() != null && cleaningProduct.getDisponibilidad()){
            productoDTO.setDisponibilidad(SINOEnum.SI);
        }else{
            productoDTO.setDisponibilidad(SINOEnum.NO);
        }
        productoDTO.setMarca(MarcaEnum.valueOf(cleaningProduct.getMarca()));// De string a enum
        productoDTO.setPrecio(cleaningProduct.getPrecio());
        productoDTO.setReferencia(cleaningProduct.getReferencia());
        productoDTO.setMateriales(cleaningProduct.getMateriales());
        productoDTO.setUrlFotografia(cleaningProduct.getUrlFotografia());
        return productoDTO;
    }
}
