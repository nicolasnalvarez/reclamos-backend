package com.uade.reclamos.controllers;

import com.uade.reclamos.model.EstadoRequest;
import com.uade.reclamos.model.NuevoReclamoRequest;
import controlador.Controlador;
import exceptions.EdificioException;
import exceptions.PersonaException;
import exceptions.ReclamoException;
import exceptions.UnidadException;
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

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public HttpEntity<Integer> generarReclamo(@RequestBody @Valid NuevoReclamoRequest reclamoRequest) throws EdificioException, PersonaException, UnidadException {
        int idNuevoReclamo = Controlador.getInstancia().generarReclamo(reclamoRequest.getReclamo(), reclamoRequest.getImagenes());
        return new ResponseEntity<>(idNuevoReclamo, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id_reclamo}", produces = "application/json")
    public HttpEntity<ReclamoView> getReclamo(@PathVariable("id_reclamo") int idreclamo) throws ReclamoException {
        return new ResponseEntity<>(Controlador.getInstancia().getReclamo(idreclamo), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{id_reclamo}/cambiar_estado", produces = "application/json")
    public HttpEntity<Integer> cambiarEstado(@RequestBody @Valid EstadoRequest nuevoEstado) throws EdificioException, PersonaException, UnidadException {
        Controlador.getInstancia().cambiarEstado()
        return new ResponseEntity<>(nuevoEstado, HttpStatus.CREATED);
    }

    @PatchMapping(path="/{id_reclamo}/update", produces = "application/json")
    public @ResponseBody String updateUser(@PathVariable int id_reclamo, @RequestBody NuevoReclamoRequest reclamoRequest) throws ReclamoException {
        ReclamoView reclamoStored = (ReclamoView) Controlador.getInstancia().getReclamo(id_reclamo);
        reclamoStored.setImagesPaths(reclamoRequest.getImagenes());
        Controlador.getInstancia().actualizarReclamo(reclamoStored);
        return new ResponseEntity<>(reclamoRequest, HttpStatus.ACCEPTED);
    }


    @RequestMapping(method = RequestMethod.GET, path = "all/{documento}", produces = "application/json")
    public HttpEntity<List<ReclamoView>> getMisReclamos(@PathVariable("documento") String documento) throws ReclamoException {
        return new ResponseEntity<>(Controlador.getInstancia().getReclamosByDNI(documento), HttpStatus.OK);
    }

}
