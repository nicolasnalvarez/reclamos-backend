package com.uade.reclamos.model;

import lombok.Data;

@Data
public class RegisterRequest {
    private String nombre;
    private String password;
    private String dni;
}
