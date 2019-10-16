package com.uade.reclamos.controllers;
import com.uade.reclamos.model.LoginRequest;
import com.uade.reclamos.model.RegisterRequest;
import controlador.Controlador;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import views.*;

@RestController
@RequestMapping
public class AccessController {


    @RequestMapping(method = RequestMethod.POST,path = "/auth/login", produces = "application/json")
    public HttpEntity<UsuarioView> loguear(@RequestBody @Valid LoginRequest loginRequest) {
        return new ResponseEntity<>(Controlador.getInstancia().login(loginRequest.getNombre(), loginRequest.getPassword()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/auth/register", produces = "application/json")
    public HttpEntity<Void> registrar(@RequestBody @Valid RegisterRequest registerRequest) {
        Controlador.getInstancia().registrar(registerRequest.getDni(),registerRequest.getNombre(), registerRequest.getPassword());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
