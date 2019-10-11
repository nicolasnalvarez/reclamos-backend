package com.uade.reclamos.model;

import lombok.Data;
import modelo.Imagen;
import modelo.Reclamo;

import java.util.List;

@Data
public class NuevoReclamoRequest {

    private Reclamo reclamo;
    private List<Imagen> imagenes;

}
