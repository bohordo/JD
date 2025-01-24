package com.juannas.jd.service;

import com.juannas.jd.repository.entity.MaquinaEntity;
import com.juannas.jd.repository.entity.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MaquinaService {
    @Autowired
    MaquinaRepository maquinaRepository;
    public List<MaquinaEntity> listAllMaquinas() {
        // Retrieve the Iterable from the repository
        Iterable<MaquinaEntity> maquinaIterable = maquinaRepository.findAll();

        // Convert Iterable to List
        return StreamSupport.stream(maquinaIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public MaquinaEntity createMaquina(MaquinaEntity maquinaEntity) {
        return maquinaRepository.save(maquinaEntity);
    }

    public void deleteMaquina(String placa) {
        maquinaRepository.deleteByPlaca(placa);
    }

    @Transactional
    public MaquinaEntity updateMaquinaByPlaca(String placa, MaquinaEntity updatedMaquina) {
        // Fetch the entity by placa
        MaquinaEntity maquina = maquinaRepository.findByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Maquina not found with placa: " + placa));

        // Update the fields
        if (updatedMaquina.getPlaca() != null && !updatedMaquina.getPlaca().isEmpty()) {
            maquina.setPlaca(updatedMaquina.getPlaca());
        }

        // Save the updated entity
        maquinaRepository.save(maquina);
        return maquina;
    }
}
