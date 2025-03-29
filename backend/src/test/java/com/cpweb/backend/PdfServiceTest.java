package com.cpweb.backend;

import com.cpweb.backend.models.Recette;
import com.cpweb.backend.service.PdfService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PdfServiceTest {

    @Test
    public void testGeneratePdf() throws Exception {
        PdfService pdfService = new PdfService();

        //ARRANGE
        Recette recette = new Recette();

        recette.setId(2L);
        recette.setNomRecette("Pizzaaaa");

        //ACT
        boolean result = pdfService.genererPDF(recette);

        //ASSERT
        assertEquals(true, result);
    }
}
