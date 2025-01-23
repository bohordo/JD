package com.juannas.jd.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MaquinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maquinaId;
    private String placa;

    public MaquinaEntity(){};
}


