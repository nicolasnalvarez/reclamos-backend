package com.uade.reclamos.controllers;

import controlador.Controlador;
import exceptions.EdificioException;
import exceptions.PersonaException;
import exceptions.UnidadException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import views.EdificioView;
import views.UnidadView;

import java.util.List;

@RestController
@RequestMapping(value = "/unidades")
public class UnidadController {

    @RequestMapping(method = RequestMethod.GET, path = "/edificios/{id_edificio}",produces = "application/json")
    public HttpEntity<List<UnidadView>> listarUnidadesPorEdificio(@PathVariable("id_edificio") int idEdificio) throws UnidadException, EdificioException {
        return new ResponseEntity<>(Controlador.getInstancia().getUnidadesPorEdificio(idEdificio), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/personas/{tipo_usuario}/{documento}/edificios/{id_edificio}",produces = "application/json")
    public HttpEntity<List<UnidadView>> getUnidadesByDocumentoAndEdificioAndTipoUsuario(@PathVariable("tipo_usuario") int tipoUsuario,
                                                                                        @PathVariable("documento") String documento,
                                                                                        @PathVariable("id_edificio") int idEdificio) throws PersonaException {
        if (tipoUsuario == 1) {
            return new ResponseEntity<>(Controlador.getInstancia().getUnidadesByDocumentoDuenioYIdEdificio(documento, idEdificio), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Controlador.getInstancia().getUnidadesByDocumentoInquilinoYIdEdificio(documento, idEdificio), HttpStatus.OK);
        }
    }

}
