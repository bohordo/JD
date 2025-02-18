package com.juannas.jd.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "proveedor")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proveedorId;

    @Column(name = "nombre_razon_social")
    @JsonProperty("nombre_razon_social")
    private String nombreRazonSocial;

    @Column(name = "tipo_identificacion")
    @JsonProperty("tipo_identificacion")
    private String tipoIdentificacion;

    @Column(name = "identificacion")
    @JsonProperty("identificacion")
    private String identificacion;

    @Column(name = "direccion")
    @JsonProperty("direccion")
    private String direccion;

    @Column(name = "tel_1")
    @JsonProperty("tel_1")
    private String telUno;

    @Column(name = "tel_2")
    @JsonProperty("tel_2")
    private String telDos;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;
}
