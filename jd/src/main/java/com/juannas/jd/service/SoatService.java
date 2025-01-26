package com.juannas.jd.service;

import com.juannas.jd.repository.entity.SoatEntity;
import com.juannas.jd.repository.SoatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SoatService {
    private final SoatRepository soatRepository;

    public SoatService(SoatRepository soatRepository) {
        this.soatRepository = soatRepository;
    }

    @Transactional
    public SoatEntity createSoat(SoatEntity soat) {
        return soatRepository.save(soat);
    }

    // GET ALL
    public List<SoatEntity> getAllSoats() {
        return StreamSupport.stream(soatRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // GET BY NUMPOLIZA
    public SoatEntity getSoatByNumeroPoliza(String numeroPoliza) {
        return soatRepository.findByNumeroPoliza(numeroPoliza)
                .orElseThrow(() -> new RuntimeException("SOAT not found"));
    }

    @Transactional
    public SoatEntity updateSoat(String numeroPoliza, SoatEntity updatedSoat) {
        SoatEntity existing = getSoatByNumeroPoliza(numeroPoliza);
        existing.setVigenciaDesde(updatedSoat.getVigenciaDesde());
        existing.setVigenciaHasta(updatedSoat.getVigenciaHasta());
        existing.setAseguradora(updatedSoat.getAseguradora());
        return soatRepository.save(existing);
    }

    @Transactional
    public void deleteSoat(String numeroPoliza) {
        soatRepository.deleteByNumeroPoliza(numeroPoliza);
    }
}
