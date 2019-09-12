package com.example.demo;


import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import controlador.Controlador;
import exceptions.EdificioException;
import exceptions.UnidadException;
import views.EdificioView;

@RestController
public class EdificiosController {

    @RequestMapping(method = RequestMethod.GET, path = "/edificios")
    @ResponseBody
    public List<EdificioView> getEdificios() throws EdificioException, UnidadException{
        return Controlador.getInstancia().getEdificios();
    }

}