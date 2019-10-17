package com.uade.reclamos.controllers;

import com.uade.reclamos.model.LoginRequest;
import com.uade.reclamos.model.RegisterRequest;
import controlador.Controlador;
import exceptions.CambioPasswordException;
import exceptions.LoginException;
import exceptions.PersonaException;
import exceptions.UsuarioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import views.UsuarioView;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AccessController {

    @RequestMapping(method = RequestMethod.POST,path = "/register", produces = "application/json")
    public HttpEntity<Void> registrar(@RequestBody @Valid RegisterRequest registerRequest) throws PersonaException {
        System.out.println("Se intenta registrar al usuario " + registerRequest.getNombre() + " con clave " + registerRequest.getPassword());
        Controlador.getInstancia().registrar(registerRequest.getDni(),registerRequest.getNombre(), registerRequest.getPassword());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/login", produces = "application/json")
    public HttpEntity<UsuarioView> login(@RequestBody @Valid LoginRequest loginRequest) throws LoginException, UsuarioException, CambioPasswordException {
        System.out.println("Se intenta loguear al usuario " + loginRequest.getNombre() + " con clave " + loginRequest.getPassword());
        return new ResponseEntity<>(Controlador.getInstancia().login(loginRequest.getNombre(), loginRequest.getPassword()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/changepass", produces = "application/json")
    public HttpEntity<Void> cambioPassword(@RequestBody @Valid LoginRequest loginRequest) throws CambioPasswordException, UsuarioException {
        Controlador.getInstancia().cambioPassword(loginRequest.getNombre(), loginRequest.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
