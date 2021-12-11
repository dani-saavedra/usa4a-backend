package com.tienda.tiendaapi.service.impl;

import com.tienda.tiendaapi.dto.ProductoDTO;
import com.tienda.tiendaapi.enums.SINOEnum;
import com.tienda.tiendaapi.modelo.CleaningProduct;
import com.tienda.tiendaapi.repository.ProductoRepository;
import com.tienda.tiendaapi.service.ProductoService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;
    private final MongoTemplate mongoTemplate;

    public ProductoServiceImpl(ProductoRepository productoRepository,
                               MongoTemplate mongoTemplate) {
        this.repository = productoRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void guardarNuevoProducto(ProductoDTO dto) {
        CleaningProduct cleaningProduct = new CleaningProduct();
        cleaningProduct.setCantidad(dto.getCantidad());
        cleaningProduct.setCategoria(dto.getCategoria());
        cleaningProduct.setDescripcion(dto.getDescripcion());
        cleaningProduct.setDisponibilidad(SINOEnum.SI.equals(dto.getDisponibilidad()));
        cleaningProduct.setMarca(dto.getMarca().name());
        cleaningProduct.setMateriales(dto.getMateriales());
        cleaningProduct.setPrecio(dto.getPrecio());
        cleaningProduct.setReferencia(dto.getReferencia());
        cleaningProduct.setUrlFotografia(dto.getUrlFotografia());
        repository.save(cleaningProduct);
    }

    @Override
    public List<ProductoDTO> obtenerProductos() {
        return repository.findAll()
                .stream()
                .map(ProductoDTO::convertDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarProducto(String referencia) {
        mongoTemplate.remove(Query.query(Criteria.where("referencia").is(referencia)), CleaningProduct.class);
    }

    @Override
    public void actualizarProducto(ProductoDTO dto) {
        Criteria referencia = Criteria.where("referencia").is(dto.getReferencia());

        CleaningProduct cleaningProductDB = mongoTemplate.findOne(Query.query(referencia), CleaningProduct.class);
        if (cleaningProductDB != null) {
            cleaningProductDB.setPrecio(dto.getPrecio());
            cleaningProductDB.setReferencia(dto.getReferencia());
            cleaningProductDB.setMarca(dto.getMarca().name());
            cleaningProductDB.setCantidad(dto.getCantidad());
            cleaningProductDB.setDisponibilidad(SINOEnum.SI.equals(dto.getDisponibilidad()));
            repository.save(cleaningProductDB);
        }
    }

    @Override
    public ProductoDTO consultarPorReferencia(String referencia) {
        CleaningProduct cleaningProduct = repository.findByReference(referencia);
        return ProductoDTO.convertDTO(cleaningProduct);

    }
}