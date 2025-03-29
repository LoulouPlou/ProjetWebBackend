package com.cpweb.backend.service;

import com.cpweb.backend.models.Recette;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class PdfService {

    public boolean genererPDF(Recette recette) throws Exception{
        Document document = new Document();
        document.setPageSize(PageSize.LETTER);

        String baseDir = System.getProperty("user.dir");
        File parentDir = new File(baseDir).getParentFile();
        File dataDir = new File(parentDir, "data");

        try{
            PdfWriter.getInstance(document, new FileOutputStream(dataDir+"/recette.pdf"));
            document.open();
            document.setMargins(5, 5, 5, 5);

            Font h1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, new BaseColor(161,113,136));
            Font h2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);

            Paragraph recipeName = new Paragraph(recette.getNomRecette(), h1);

            Paragraph paragraph = new Paragraph("My super duper cute cat", h1);
            paragraph.setAlignment(Element.ALIGN_CENTER);

            Image image = Image.getInstance(dataDir+"/meowmeow.jpg");
            image.scalePercent(40);
            image.setAlignment(Element.ALIGN_CENTER);

            document.add(recipeName);
            document.add(image);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        document.close();
        return new File(dataDir+"/recette.pdf").exists();
    }
}
