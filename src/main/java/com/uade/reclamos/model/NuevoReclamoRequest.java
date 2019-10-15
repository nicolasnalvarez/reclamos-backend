package com.uade.reclamos.model;

import lombok.Data;
import request.ImagenRequest;
import request.ReclamoRequest;

import java.util.List;

@Data
public class NuevoReclamoRequest {

    private ReclamoRequest reclamo;
    private List<ImagenRequest> imagenes;

}
