package com.uade.reclamos.controllers;

import com.uade.reclamos.model.NuevoReclamoRequest;
import controlador.Controlador;
import exceptions.ReclamoException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import views.ReclamoView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/reclamos")
public class ReclamoController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public HttpEntity<List<ReclamoView>> listarTodosLosReclamos() throws ReclamoException {
        return new ResponseEntity<>(Controlador.getInstancia().todosLosReclamos(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public HttpEntity<Void> generarReclamo(@RequestBody @Valid NuevoReclamoRequest reclamoRequest) {
        Controlador.getInstancia().generarReclamo(reclamoRequest.getReclamo(), reclamoRequest.getImagenes());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id_reclamo}", produces = "application/json")
    public HttpEntity<ReclamoView> getReclamo(@PathVariable("id_reclamo") int idreclamo) {
        return new ResponseEntity<>(Controlador.getInstancia().getReclamo(idreclamo), HttpStatus.OK);
    }

}
