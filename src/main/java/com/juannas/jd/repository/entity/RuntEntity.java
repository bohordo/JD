package com.juannas.jd.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class RuntEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int runtId;

    //@ManyToMany(fetch = FetchType.LAZY)
    //private List<ClienteEntity> clientes;
    //@ManyToMany(fetch = FetchType.LAZY)
    //private List<ProyectoEntity> proyectos;
    private String placa;
    private String linea;
    private String tipoEquipo;
    private long modelo;
    private String color;
    private long kilometros;
    private long horometro;
    private String accesorios;
    private String manifestoImportacion;
    //@OneToOne(cascade = CascadeType.ALL)
    //private SoatEntity soat;
    private LocalDate poliza;
    //@ManyToOne(fetch = FetchType.LAZY)
    //private PropietarioEntity propietario;
    //@ManyToOne(fetch = FetchType.LAZY)
    //private ProveedorEntity proveedor;
    private LocalDate rtm;
    private String motor;
    private String vinChasis;
    private String marca;

}
