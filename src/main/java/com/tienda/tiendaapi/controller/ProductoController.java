package com.tienda.tiendaapi.controller;


import com.tienda.tiendaapi.dto.GeneralResponse;
import com.tienda.tiendaapi.dto.ProductoDTO;
import com.tienda.tiendaapi.modelo.Producto;
import com.tienda.tiendaapi.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/producto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService productoService) {
        this.service = productoService;
    }

    @PostMapping(path = "/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public GeneralResponse guardarNuevoProducto(@RequestBody ProductoDTO productoDTO) {
        service.guardarNuevoProducto(productoDTO);
        return new GeneralResponse("Producto guardado correctamente");
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public List<ProductoDTO> consultarProductos() {
        return service.obtenerProductos();
    }

    @DeleteMapping(path = "/eliminar")
    public GeneralResponse eliminarProducto(@RequestBody Producto producto) {
        service.eliminarProducto(producto.getReferencia());
        return new GeneralResponse("ok");
    }
}
