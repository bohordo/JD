package com.juannas.jd.controller;

import com.juannas.jd.repository.entity.ProveedorEntity;
import com.juannas.jd.service.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }
    @PostMapping(path = "/create")
    public ResponseEntity<ProveedorEntity> createProveedor(@RequestBody ProveedorEntity proveedor) {
        return ResponseEntity.ok(proveedorService.createProveedor(proveedor));
    }
    // GET ALL
    @GetMapping(path = "/list")
    public ResponseEntity<List<ProveedorEntity>> getAllProveedores() {
        return ResponseEntity.ok(proveedorService.getAllProveedores());
    }
    /*
    // GET BY ID
    @GetMapping("/{identificacion}")
    public ResponseEntity<ProveedorEntity> getProveedor(@PathVariable String identificacion) {
        return ResponseEntity.ok(proveedorService.getProveedorByIdentificacion(identificacion));
    }
    */
    @PutMapping("/update/{identificacion}")
    public ResponseEntity<ProveedorEntity> updateProveedor(@PathVariable String identificacion,
                                                           @RequestBody ProveedorEntity proveedor) {
        return ResponseEntity.ok(proveedorService.updateProveedor(identificacion, proveedor));
    }


    @DeleteMapping("/delete/{identificacion}")
    public ResponseEntity<String> deleteProveedor(@PathVariable String identificacion) {
        proveedorService.deleteProveedor(identificacion);
        return ResponseEntity.ok().body("Deleted proveedor by identificacion: " + identificacion);
    }
}
