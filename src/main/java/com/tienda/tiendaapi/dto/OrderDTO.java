package com.tienda.tiendaapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private String cliente;
    private List<ProductoDTO> productos;
}