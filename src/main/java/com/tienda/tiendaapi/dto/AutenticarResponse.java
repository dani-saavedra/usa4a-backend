package com.tienda.tiendaapi.dto;

import com.tienda.tiendaapi.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutenticarResponse {
    private Usuario usuario;
}
