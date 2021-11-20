package com.tienda.tiendaapi.controller;

import com.tienda.tiendaapi.dto.AutenticarDTO;
import com.tienda.tiendaapi.dto.AutenticarResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AuthController {

    @GetMapping(path = "/saludar")
    public String saludar() {
        return "Hola mundo";
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public AutenticarResponse autenticar(@RequestBody AutenticarDTO user) {
        System.out.println(user);
        if (user.getClave().equals("CLAVEDANIEL")
                && user.getUsuario().equalsIgnoreCase("admin")) {
            return new AutenticarResponse("mensaje");
        } else {
            return new AutenticarResponse("falle");
        }
    }
}
