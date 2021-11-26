package com.tienda.tiendaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class GeneralResponse implements Serializable {
    private String mensaje;
}
