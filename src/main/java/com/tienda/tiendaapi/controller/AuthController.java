package com.tienda.tiendaapi.controller;

import com.tienda.tiendaapi.dto.AutenticarDTO;
import com.tienda.tiendaapi.dto.AutenticarResponse;
import com.tienda.tiendaapi.modelo.Usuario;
import com.tienda.tiendaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class AuthController {

    @Autowired
    private UsuarioService servicio;

    @GetMapping(path = "/saludar")
    public String saludar() {
        servicio.guardar("Daniel", 1151L);
        return "Hola mundo";
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public AutenticarResponse autenticar(@RequestBody AutenticarDTO user) {
        List<Usuario> autenticar = servicio.autenticar(user.getUsuario(), user.getClave());
        if (autenticar.isEmpty()) {
            return new AutenticarResponse(new Usuario());
        } else {
            return new AutenticarResponse(autenticar.get(0));
        }
    }
}
