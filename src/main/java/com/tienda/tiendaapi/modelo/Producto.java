package com.tienda.tiendaapi.modelo;

import com.mongodb.lang.NonNull;
import com.tienda.tiendaapi.dto.ProductoDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
Desde el navegador web o browser,
 el sistema mostrará una página que incluirá un formulario en donde el Administrador del sistema podrá
  Agregar los datos de los productos de aseo a la BD, es decir,
   registrar su referencia, marca, categoría, materiales, descripción, disponibilidad (SI/NO), precio, cantidad en stock y
    fotografía (URL). En el momento de hacer clic en el botón Guardar el sistema creará la ficha de producto.
 */
@Document(collection = "productos")
@Data
public class Producto {
    @Id
    private String id;

    @NonNull
    private String referencia;
    @NonNull
    private String marca;

    private String materiales;

    //Dejarlo como un objeto
    private String categoria;
    private String descripcion;

    @NonNull
    private Boolean disponibilidad;
    @NonNull
    private Integer precio;
    @NonNull
    private Integer cantidad;
    private String urlFotografia;
}
