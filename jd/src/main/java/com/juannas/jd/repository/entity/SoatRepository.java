package com.juannas.jd.repository.entity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface SoatRepository extends CrudRepository<SoatEntity, Integer> {
    Optional<SoatEntity> findByNumeroPoliza(String numeroPoliza);

    @Transactional
    @Modifying
    @Query("DELETE FROM SoatEntity s WHERE s.numeroPoliza = :numeroPoliza")
    void deleteByNumeroPoliza(String numeroPoliza);
}