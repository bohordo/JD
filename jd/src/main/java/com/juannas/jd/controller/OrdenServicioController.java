package com.juannas.jd.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.juannas.jd.controller.dto.OrdenServicioInformativaDto;
import com.juannas.jd.controller.dto.OrdenServicioInformativaFinalDto;
import com.juannas.jd.mapper.OrdenServicioMapper;
import com.juannas.jd.repository.entity.OrdenServicioInformativaEntity;
import com.juannas.jd.service.OrdenServicioService;
import com.juannas.jd.service.file.PdfService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orden-servicio")
public class OrdenServicioController {

    private final OrdenServicioService ordenServicioService;

    @Autowired
    OrdenServicioMapper ordenServicioMapper;

    @Autowired
    PdfService pdfService;

    @Autowired
    public OrdenServicioController(OrdenServicioService ordenServicioService) {
        this.ordenServicioService = ordenServicioService;
    }

    @GetMapping
    public ResponseEntity<List<OrdenServicioInformativaEntity>> getAllOrdenes() {
        return ResponseEntity.ok(ordenServicioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenServicioInformativaEntity> getOrdenById(@PathVariable int id) {
        return ordenServicioService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden de servicio no encontrada"));
    }

    @PostMapping
    public ResponseEntity<OrdenServicioInformativaEntity> createOrden(@RequestBody OrdenServicioInformativaEntity ordenServicio) {
        OrdenServicioInformativaEntity savedOrden = ordenServicioService.save(ordenServicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenServicioInformativaEntity> updateOrden(
            @PathVariable int id,
            @RequestBody OrdenServicioInformativaEntity ordenServicio) {
        return ResponseEntity.ok(ordenServicioService.update(id, ordenServicio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable int id) {
        ordenServicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/informativa")
    public ResponseEntity<OrdenServicioInformativaFinalDto> createSOI(@RequestBody OrdenServicioInformativaDto ordenServicioInformativaDto) {
        OrdenServicioInformativaEntity savedOSI = ordenServicioService.saveSOI(ordenServicioInformativaDto);
        OrdenServicioInformativaFinalDto dto = ordenServicioMapper.toDto(savedOSI);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/informativa/pdf")
    public ResponseEntity<byte[]> createSOIPdf(@RequestBody OrdenServicioInformativaDto ordenServicioInformativaDto) throws JsonProcessingException {
        OrdenServicioInformativaEntity savedOSI = ordenServicioService.saveSOI(ordenServicioInformativaDto);
        OrdenServicioInformativaFinalDto dto = ordenServicioMapper.toDto(savedOSI);

        String consecutivo = dto.getConsecutivoOrdenInformativa();

        byte[] pdfBytes = pdfService.generatePdfFromJson(dto);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=orden_servicio_"+consecutivo+".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

    @PostMapping(value = "/informativa/csv", produces = "text/csv")
    public void exportToCSV(@RequestBody OrdenServicioInformativaDto ordenServicioInformativaDto, HttpServletResponse response) throws IOException {
        OrdenServicioInformativaEntity savedOSI = ordenServicioService.saveSOI(ordenServicioInformativaDto);
        OrdenServicioInformativaFinalDto dto = ordenServicioMapper.toDto(savedOSI);

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=orden_servicio.csv");

        // Convertir DTO a CSV automáticamente
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(OrdenServicioInformativaFinalDto.class).withHeader();

        csvMapper.writer(schema).writeValue(response.getWriter(), dto);
    }
}
