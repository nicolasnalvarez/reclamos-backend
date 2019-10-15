package com.uade.reclamos.controllers;

import controlador.Controlador;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import views.*;

@RestController
public class AccessController {


    @PostMapping(path = "/auth/login", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String loguear(@RequestBody UsuarioView usuario)  {
        Controlador.getInstancia().login(usuario.getNombre(),usuario.getPaswword());
        return "Usuario logueado";
    }



}
