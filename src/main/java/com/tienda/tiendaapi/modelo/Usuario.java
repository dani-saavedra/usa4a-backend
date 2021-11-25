package com.tienda.tiendaapi.modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;

    private Long cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correoElectronico;
}