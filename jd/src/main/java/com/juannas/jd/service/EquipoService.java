package com.juannas.jd.service;

import com.juannas.jd.repository.*;
import com.juannas.jd.repository.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EquipoService {
    private final EquipoRepository maquinaRepository;
    private final PropietarioRepository propietarioRepository;
    private final ProveedorRepository proveedorRepository;
    private final SoatRepository soatRepository;
    private final ProyectoRepository proyectoRepository; // Check relation
    private final ClienteRepository clienteRepository; // Check relation

    public EquipoService(EquipoRepository maquinaRepository,
                         PropietarioRepository propietarioRepository,
                         ProveedorRepository proveedorRepository,
                         SoatRepository soatRepository,
                         ProyectoRepository proyectoRepository,
                         ClienteRepository clienteRepository) {
        this.maquinaRepository = maquinaRepository;
        this.propietarioRepository = propietarioRepository;
        this.proveedorRepository = proveedorRepository;
        this.soatRepository = soatRepository;
        this.proyectoRepository = proyectoRepository;
        this.clienteRepository = clienteRepository;
    }

    // CREATE
    @Transactional
    public EquipoEntity createMaquina(EquipoEntity maquina) {
        // Link relationships
        linkPropietario(maquina);
        linkProveedor(maquina);
        linkSoat(maquina);
        return maquinaRepository.save(maquina);
    }

    // READ ALL
    public List<EquipoEntity> getAllMaquinas() {
        return StreamSupport.stream(maquinaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // READ BY PLACA
    public EquipoEntity getMaquinaByPlaca(String placa) {
        return maquinaRepository.findByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Machine not found"));
    }

    // UPDATE BY PLACA
    @Transactional
    public EquipoEntity updateMaquinaByPlaca(String placa, EquipoEntity updatedMaquina) {
        EquipoEntity existing = getMaquinaByPlaca(placa);
        existing.setPlaca(updatedMaquina.getPlaca());
        existing.setLinea(updatedMaquina.getLinea());
        existing.setTipoEquipo(updatedMaquina.getTipoEquipo());
        existing.setModelo(updatedMaquina.getModelo());
        existing.setColor(updatedMaquina.getColor());
        existing.setKilometros(updatedMaquina.getKilometros());
        existing.setHorometro(updatedMaquina.getHorometro());
        existing.setAccesorios(updatedMaquina.getAccesorios());
        existing.setManifestoImportacion(updatedMaquina.getManifestoImportacion());
        existing.setPoliza(updatedMaquina.getPoliza());
        existing.setRtm(updatedMaquina.getRtm());
        existing.setMotor(updatedMaquina.getMotor());
        existing.setVinChasis(updatedMaquina.getVinChasis());
        existing.setMarca(updatedMaquina.getMarca());

        // Update relationships
        linkPropietario(existing);
        linkProveedor(existing);
        linkSoat(existing);
        return maquinaRepository.save(existing);
    }

    // DELETE BY PLACA
    @Transactional
    public void deleteMaquinaByPlaca(String placa) {
        maquinaRepository.deleteByPlaca(placa);
    }

    // HELPER METHODS TO LINK RELATIONSHIPS
    private void linkPropietario(EquipoEntity maquina) {
        if (maquina.getPropietario() != null && maquina.getPropietario().getIdentificacion() != null) {
            PropietarioEntity propietario = propietarioRepository.findByIdentificacion(maquina.getPropietario().getIdentificacion())
                    .orElseThrow(() -> new RuntimeException("Propietario not found"));
            maquina.setPropietario(propietario);
            propietario.getMaquinas().add(maquina);
        }
    }

    private void linkProveedor(EquipoEntity maquina) {
        if (maquina.getProveedor() != null && maquina.getProveedor().getIdentificacion() != null) {
            ProveedorEntity proveedor = proveedorRepository.findByIdentificacion(maquina.getProveedor().getIdentificacion())
                    .orElseThrow(() -> new RuntimeException("Proveedor not found"));
            maquina.setProveedor(proveedor);
            //proveedor.getMaquinas().add(maquina);
        }
    }

    private void linkSoat(EquipoEntity maquina) {
        if (maquina.getSoat() != null && maquina.getSoat().getNumeroPoliza() != null) {
            SoatEntity soat = soatRepository.findByNumeroPoliza(maquina.getSoat().getNumeroPoliza())
                    .orElseThrow(() -> new RuntimeException("SOAT not found"));
            maquina.setSoat(soat);
        }
    }
}