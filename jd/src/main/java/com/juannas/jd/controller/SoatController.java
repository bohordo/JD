package com.juannas.jd.controller;

import com.juannas.jd.repository.entity.SoatEntity;
import com.juannas.jd.service.SoatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soats")
public class SoatController {
    private final SoatService soatService;

    public SoatController(SoatService soatService) {
        this.soatService = soatService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<SoatEntity> createSoat(@RequestBody SoatEntity soat) {
        return ResponseEntity.ok(soatService.createSoat(soat));
    }
    // GET ALL
    @GetMapping(path = "/list")
    public ResponseEntity<List<SoatEntity>> getAllSoats() {
        return ResponseEntity.ok(soatService.getAllSoats());
    }
    /*
    // GET By NUMPOLIZA
    @GetMapping("/{numeroPoliza}")
    public ResponseEntity<SoatEntity> getSoat(@PathVariable String numeroPoliza) {
        return ResponseEntity.ok(soatService.getSoatByNumeroPoliza(numeroPoliza));
    }
    */
    @PutMapping("/update/{numeroPoliza}")
    public ResponseEntity<SoatEntity> updateSoat(@PathVariable String numeroPoliza,
                                                 @RequestBody SoatEntity soat) {
        return ResponseEntity.ok(soatService.updateSoat(numeroPoliza, soat));
    }

    @DeleteMapping("/delete/{numeroPoliza}")
    public ResponseEntity<String> deleteSoat(@PathVariable String numeroPoliza) {
        soatService.deleteSoat(numeroPoliza);
        return ResponseEntity.ok().body("Deleted soat by numero de poliza: " + numeroPoliza);
    }
}
