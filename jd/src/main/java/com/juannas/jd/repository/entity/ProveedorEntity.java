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
@Table(name = "proveedor")
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proveedorId;
    private String identificacion;
    private String nombre;
    private String tipoIdentificacion;
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<EquipoEntity> maquinas = new ArrayList<>();
}
