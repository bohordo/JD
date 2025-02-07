package com.juannas.jd.service.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public byte[] generatePdfFromJson(Object object) throws JsonProcessingException {
        try {
            // Convertir objeto a JSON String
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();

            // Agregar título
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            document.add(new Paragraph("Orden de Servicio Informativa", titleFont));
            document.add(new Paragraph("\n"));

            // Agregar JSON al PDF
            Font jsonFont = new Font(Font.FontFamily.COURIER, 10);
            document.add(new Paragraph(jsonString, jsonFont));

            document.close();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar PDF", e);
        }
    }
}
