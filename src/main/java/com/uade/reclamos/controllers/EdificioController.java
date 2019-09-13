package com.uade.reclamos.controllers;

import controlador.Controlador;
import exceptions.EdificioException;
import exceptions.UnidadException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import views.EdificioView;

import java.util.List;

@RestController
@RequestMapping(value = "/edificios")
public class EdificioController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public HttpEntity<List<EdificioView>> listarEdificios() throws UnidadException, EdificioException {
        return new ResponseEntity<>(Controlador.getInstancia().getEdificios(), HttpStatus.OK);
    }

}
