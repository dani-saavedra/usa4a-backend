package com.tienda.tiendaapi.modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
@Data
public class Cliente {

    @Id
    private String id;

    private String nombre;
}