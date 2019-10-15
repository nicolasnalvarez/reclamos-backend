package com.uade.reclamos.controllers;

import controlador.Controlador;
import exceptions.EdificioException;
import exceptions.PersonaException;
import exceptions.UnidadException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import views.EdificioView;
import views.UnidadView;

import java.util.List;

@RestController
@RequestMapping(value = "/edificios")
public class EdificioController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public HttpEntity<List<EdificioView>> listarEdificios() throws UnidadException, EdificioException {
        return new ResponseEntity<>(Controlador.getInstancia().getEdificios(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/personas/{tipo_usuario}/{documento}", produces = "application/json")
    public HttpEntity<List<EdificioView>> getEdificiosPorDocumentoYTipoUsuario(@PathVariable("tipo_usuario") int tipoUsuario,
                                                                               @PathVariable("documento") String documento) throws PersonaException {
        if (tipoUsuario == 1) {
            return new ResponseEntity<>(Controlador.getInstancia().getEdificiosByDocumentoDuenio(documento), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Controlador.getInstancia().getEdificiosByDocumentoInquilino(documento), HttpStatus.OK);
        }
    }

}
