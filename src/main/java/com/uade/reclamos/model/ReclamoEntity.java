package com.uade.reclamos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reclamos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReclamoEntity {

    @Id
    private Integer id;
}
