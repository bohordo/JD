package com.juannas.jd.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MaquinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maquinaId;

    private String placa;
}


