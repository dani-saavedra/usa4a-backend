package com.tienda.tiendaapi.modelo;

import com.mongodb.lang.NonNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
@Data
public class Producto {
    @Id
    private String id;

    @NonNull
    private String referencia;
    @NonNull
    private String marca;
    @NonNull
    private Boolean disponibilidad;
    @NonNull
    private Integer precio;
    @NonNull
    private Integer cantidad;

    private String materiales;

    //Dejarlo como un objeto
    private String categoria;
    private String descripcion;

    private String urlFotografia;
}
