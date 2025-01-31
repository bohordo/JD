package com.juannas.jd.service;

import com.juannas.jd.repository.EquipoRepository;
import com.juannas.jd.repository.entity.ProveedorEntity;
import com.juannas.jd.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;
    private final EquipoRepository maquinaRepository; //Check relation

    public ProveedorService(ProveedorRepository proveedorRepository,
                            EquipoRepository maquinaRepository) {
        this.proveedorRepository = proveedorRepository;
        this.maquinaRepository = maquinaRepository;
    }

    @Transactional
    public ProveedorEntity createProveedor(ProveedorEntity proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // GET ALL
    public List<ProveedorEntity> getAllProveedores() {
        return StreamSupport.stream(proveedorRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
    // GET BY ID
    public ProveedorEntity getProveedorByIdentificacion(String identificacion) {
        return proveedorRepository.findByIdentificacion(identificacion)
                .orElseThrow(() -> new RuntimeException("Proveedor not found"));
    }

    @Transactional
    public ProveedorEntity updateProveedor(String identificacion,
                                           ProveedorEntity updatedProveedor) {
        ProveedorEntity existing = getProveedorByIdentificacion(identificacion);
        existing.setNombre(updatedProveedor.getNombre());
        existing.setTipoIdentificacion(updatedProveedor.getTipoIdentificacion());
        return proveedorRepository.save(existing);
    }

    @Transactional
    public void deleteProveedor(String identificacion) {
        proveedorRepository.deleteByIdentificacion(identificacion);
    }
}
