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
import views.PersonaView;

import java.util.List;

@RestController
@RequestMapping
public class PersonaController {

    @RequestMapping(method = RequestMethod.GET, path = "/habilitados/edificios", produces = "application/json")
    public HttpEntity<List<PersonaView>> listarHabilitadosPorEdificio(@PathVariable("id_edificio") int idEdificio) throws EdificioException, PersonaException, UnidadException {
        return new ResponseEntity<>(Controlador.getInstancia().habilitadosPorEdificio(idEdificio), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/dueños/edificios", produces = "application/json")
    public HttpEntity<List<PersonaView>> listarDueñosPorEdificio(@PathVariable("id_edificio") int idEdificio) throws EdificioException, PersonaException, UnidadException {
        return new ResponseEntity<>(Controlador.getInstancia().dueniosPorEdificio(idEdificio), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/inquilinos/edificios", produces = "application/json")
    public HttpEntity<List<PersonaView>> listarInquilinosPorEdificio(@PathVariable("id_edificio") int idEdificio) throws EdificioException, PersonaException, UnidadException {
        return new ResponseEntity<>(Controlador.getInstancia().inquilinosPorEdificio(idEdificio), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/habitantes/edificios", produces = "application/json")
    public HttpEntity<List<PersonaView>> listarHabitantesPorEdificio(@PathVariable("id_edificio") int idEdificio) throws EdificioException, PersonaException, UnidadException {
        return new ResponseEntity<>(Controlador.getInstancia().habitantesPorEdificio(idEdificio), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/dueños/unidades", produces = "application/json")
    public HttpEntity<List<PersonaView>> listarDueñosPorUnidad(@PathVariable("id_edificio") int idEdificio,
                                                               @PathVariable("piso") String piso,
                                                               @PathVariable("numero") String numero) throws EdificioException, PersonaException, UnidadException {
        return new ResponseEntity<>(Controlador.getInstancia().dueniosPorUnidad(idEdificio, piso, numero), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/inquilinos/unidades", produces = "application/json")
    public HttpEntity<List<PersonaView>> listarInquilinosPorUnidad(@PathVariable("id_edificio") int idEdificio,
                                                               @PathVariable("piso") String piso,
                                                               @PathVariable("numero") String numero) throws EdificioException, PersonaException, UnidadException {
        return new ResponseEntity<>(Controlador.getInstancia().inquilinosPorUnidad(idEdificio, piso, numero), HttpStatus.OK);
    }
}
