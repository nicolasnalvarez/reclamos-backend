package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import controlador.Controlador;

@RestController
public class ReclamosController {
	
    @PostMapping(path = "/reclamos/create", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String addReclamo(@RequestBody ReclamoView reclamo)  {
        Controlador.getInstancia().altaReclamo(reclamo);
        return "Reclamo realizado creado con exito";
    }

}
