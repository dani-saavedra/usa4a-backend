package com.tienda.tiendaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludarController {

    @GetMapping(path = "/despedirse")
    public String salude(){
        return "chao mundo";
    }
}
