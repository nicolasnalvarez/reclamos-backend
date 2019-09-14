package com.uade.reclamos.services;

import com.uade.reclamos.ReclamoDAO;
import com.uade.reclamos.exceptions.ReclamoException;
import com.uade.reclamos.model.Reclamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoService {

    private final ReclamoDAO reclamoDAO;

    @Autowired
    public ReclamoService(ReclamoDAO reclamoDAO) {
        this.reclamoDAO = reclamoDAO;
    }

    public List<Reclamo> listarTodosLosReclamos() throws ReclamoException {
        return reclamoDAO.getAll();
    }

}
