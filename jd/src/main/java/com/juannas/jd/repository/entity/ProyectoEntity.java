package com.juannas.jd.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProyectoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proyectoId;
    private String nombre;
    @ManyToMany(mappedBy = "proyectos")
    private List<MaquinaEntity> maquinas = new ArrayList<>();
}
