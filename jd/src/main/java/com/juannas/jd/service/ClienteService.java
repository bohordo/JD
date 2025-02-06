package com.juannas.jd.service;

import com.juannas.jd.repository.ClienteRepository;
import com.juannas.jd.repository.EquipoRepository;
import com.juannas.jd.repository.ProyectoRepository;
import com.juannas.jd.repository.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ProyectoRepository proyectoRepository; // Check relation
    private final EquipoRepository maquinaRepository;

    public ClienteService(ClienteRepository clienteRepository,
                          ProyectoRepository proyectoRepository,
                          EquipoRepository equipoRepository) {
        this.clienteRepository = clienteRepository;
        this.proyectoRepository = proyectoRepository;
        this.maquinaRepository = equipoRepository;
    }

    // CREATE
    @Transactional
    public ClienteEntity createCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    // READ ALL
    public List<ClienteEntity> getAllClientes() {
        return StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // READ BY IDENTIFICACION
    public ClienteEntity getClienteByIdentificacion(String identificacion) {
        return clienteRepository.findByIdentificacion(identificacion)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    // UPDATE BY IDENTIFICACION
    @Transactional
    public ClienteEntity updateClienteByIdentificacion(String identificacion, ClienteEntity updatedCliente) {
        ClienteEntity existing = getClienteByIdentificacion(identificacion);
        existing.setNombre(updatedCliente.getNombre());
        existing.setTipoIdentificacion(updatedCliente.getTipoIdentificacion());
        return clienteRepository.save(existing);
    }

    // DELETE BY IDENTIFICACION
    @Transactional
    public void deleteClienteByIdentificacion(String identificacion) {
        clienteRepository.deleteByIdentificacion(identificacion);
    }

    // LINK MAQUINA TO CLIENTE
    @Transactional
    public void addMaquinaToCliente(String clienteIdentificacion, String maquinaPlaca) {
        ClienteEntity cliente = getClienteByIdentificacion(clienteIdentificacion);
        EquipoEntity maquina = maquinaRepository.findByPlaca(maquinaPlaca)
                .orElseThrow(() -> new RuntimeException("Machine not found"));

        //cliente.getMaquinasAlquiladas().add(maquina);
        //maquina.getClientes().add(cliente);
        maquinaRepository.save(maquina);
    }

    // UNLINK MAQUINA FROM CLIENTE
    @Transactional
    public void removeMaquinaFromCliente(String clienteIdentificacion, String maquinaPlaca) {
        ClienteEntity cliente = getClienteByIdentificacion(clienteIdentificacion);
        EquipoEntity maquina = maquinaRepository.findByPlaca(maquinaPlaca)
                .orElseThrow(() -> new RuntimeException("Machine not found"));

        //cliente.getMaquinasAlquiladas().remove(maquina);
        //maquina.getClientes().remove(cliente);
        maquinaRepository.save(maquina);
    }
}