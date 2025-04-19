package com.cpweb.backend.service;

import com.cpweb.backend.models.RecetteDTO;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.*;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.properties.TextAlignment;
import org.springframework.stereotype.Service;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public byte[] genererPDF(RecetteDTO recette) throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.setDefaultPageSize(PageSize.LETTER);
        Document document = new Document(pdfDoc);

        try {
            PdfFont fontTitle = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
            PdfFont fontSubtitle = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

            Paragraph title = new Paragraph(recette.getNomRecette())
                    .setFont(fontTitle)
                    .setFontSize(20)
                    .setTextAlignment(TextAlignment.CENTER);

            document.setMargins(20, 20, 20, 20);
            document.add(title);

            document.close();
            return baos.toByteArray();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
