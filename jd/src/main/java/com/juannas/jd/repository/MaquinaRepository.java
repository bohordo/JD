package com.juannas.jd.repository;

import com.juannas.jd.repository.entity.MaquinaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface MaquinaRepository extends CrudRepository<MaquinaEntity, Integer> {
    Optional<MaquinaEntity> findByPlaca(String placa);

    @Transactional
    @Modifying
    @Query("DELETE FROM MaquinaEntity m WHERE m.placa = :placa")
    void deleteByPlaca(String placa);

    List<MaquinaEntity> findByPlacaIn(List<String> placas);
}
