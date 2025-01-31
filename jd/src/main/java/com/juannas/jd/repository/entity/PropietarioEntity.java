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
@Table(name = "propietario")
public class PropietarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propietarioId;
    private String identificacion;
    private String nombre;
    private String tipoIdentificacion;
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<EquipoEntity> maquinas = new ArrayList<>();
}