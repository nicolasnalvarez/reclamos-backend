package com.uade.reclamos.model;

import lombok.Data;

@Data
public class LoginRequest {

    private String nombre;
    private String password;

}