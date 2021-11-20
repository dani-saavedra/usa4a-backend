package com.tienda.tiendaapi.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AutenticarDTO {
    private String usuario;
    private String clave;
}
