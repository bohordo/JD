package com.juannas.jd.controller;

import com.juannas.jd.repository.entity.ClienteEntity;
import com.juannas.jd.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ClienteEntity> createCliente(@RequestBody ClienteEntity cliente) {
        return ResponseEntity.ok(clienteService.createCliente(cliente));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAllClientes());
    }
/*
    // GET BY IDENTIFICACION
    @GetMapping("/by-identificacion/{identificacion}")
    public ResponseEntity<ClienteEntity> getClienteByIdentificacion(@PathVariable String identificacion) {
        return ResponseEntity.ok(clienteService.getClienteByIdentificacion(identificacion));
    }
*/
    // UPDATE BY IDENTIFICACION
    @PutMapping("/update/{identificacion}")
    public ResponseEntity<ClienteEntity> updateCliente(
            @PathVariable String identificacion,
            @RequestBody ClienteEntity updatedCliente
    ) {
        return ResponseEntity.ok(clienteService.updateClienteByIdentificacion(identificacion, updatedCliente));
    }

    // DELETE BY IDENTIFICACION
    @DeleteMapping("/delete/{identificacion}")
    public ResponseEntity<String> deleteClienteByIdentificacion(@PathVariable String identificacion) {
        clienteService.deleteClienteByIdentificacion(identificacion);
        return ResponseEntity.ok().body("Deleted cliente by identificacion de poliza: " + identificacion);
    }
/*
    // LINK/UNLINK MAQUINA
    @PostMapping("/{clienteIdentificacion}/maquinas/{maquinaPlaca}")
    public ResponseEntity<Void> addMaquinaToCliente(
            @PathVariable String clienteIdentificacion,
            @PathVariable String maquinaPlaca
    ) {
        clienteService.addMaquinaToCliente(clienteIdentificacion, maquinaPlaca);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{clienteIdentificacion}/maquinas/{maquinaPlaca}")
    public ResponseEntity<Void> removeMaquinaFromCliente(
            @PathVariable String clienteIdentificacion,
            @PathVariable String maquinaPlaca
    ) {
        clienteService.removeMaquinaFromCliente(clienteIdentificacion, maquinaPlaca);
        return ResponseEntity.noContent().build();
    }

 */
}
