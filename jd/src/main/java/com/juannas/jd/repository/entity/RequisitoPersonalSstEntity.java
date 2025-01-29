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
public class RequisitoPersonalSstEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "nombre_razon_social")
    @JsonProperty("nombre_razon_social")
    private String nombreRazonSocial;

    @Column(name = "cedula_nit")
    @JsonProperty("cedula_nit")
    private String cedulaNit;

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
