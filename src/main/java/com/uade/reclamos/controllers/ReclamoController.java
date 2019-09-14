package com.uade.reclamos.controllers;

import com.uade.reclamos.exceptions.ReclamoException;
import com.uade.reclamos.model.Reclamo;
import com.uade.reclamos.services.ReclamoService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reclamos")
public class ReclamoController {

    private final ReclamoService reclamoService;

    public ReclamoController(ReclamoService reclamoService) {
        this.reclamoService = reclamoService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public HttpEntity<List<Reclamo>> listarTodosLosReclamos() throws ReclamoException {
        return new ResponseEntity<>(reclamoService.listarTodosLosReclamos(), HttpStatus.OK);
    }

}
