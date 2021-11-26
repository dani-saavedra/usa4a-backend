package com.tienda.tiendaapi.service.impl;

import com.tienda.tiendaapi.dto.ProductoDTO;
import com.tienda.tiendaapi.enums.SINOEnum;
import com.tienda.tiendaapi.modelo.Producto;
import com.tienda.tiendaapi.repository.ProductoRepository;
import com.tienda.tiendaapi.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.repository = productoRepository;
    }

    @Override
    public void guardarNuevoProducto(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setCantidad(dto.getCantidad());
        producto.setCategoria(dto.getCategoria());
        producto.setDescripcion(dto.getDescripcion());
        producto.setDisponibilidad(SINOEnum.SI.equals(dto.getDisponibilidad()));
        producto.setMarca(dto.getMarca());
        producto.setMateriales(dto.getMateriales());
        producto.setPrecio(dto.getPrecio());
        producto.setReferencia(dto.getReferencia());
        producto.setUrlFotografia(dto.getUrlFotografia());
        repository.save(producto);
    }

    @Override
    public List<ProductoDTO> obtenerProductos() {
        return repository.findAll()
                .stream()
                .map(ProductoDTO::convertDTO)
                .collect(Collectors.toList());
    }
}