package com.uade.reclamos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reclamo {

    private int id;

    public ReclamoView toReclamoView(int id) {
        return new ReclamoView(id);
    }
}
