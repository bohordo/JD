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
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteId;
    private String identificacion;
    private String tipoIdentificacion;
    private String nombre;
    private String proyecto;
    @ManyToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    private List<MaquinaEntity> maquinasAlquiladas = new ArrayList<>();
}
