package com.juannas.jd.repository;

import com.juannas.jd.repository.entity.EquipoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface EquipoRepository extends CrudRepository<EquipoEntity, Integer> {

    Optional<EquipoEntity> findByPlaca(String placa);

    @Transactional
    @Modifying
    @Query("DELETE FROM EquipoEntity m WHERE m.placa = :placa")
    void deleteByPlaca(String placa);

    List<EquipoEntity> findByPlacaIn(List<String> placas);
}
