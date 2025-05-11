package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Recette;
import com.cpweb.backend.models.RecetteDTO;
import com.cpweb.backend.service.PdfService;
import com.cpweb.backend.service.RecetteDTOService;
import com.cpweb.backend.service.RecetteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/recette")
@CrossOrigin()
public class RecetteController {

    @Autowired
    RecetteDTOService recetteDTOService;

    @Autowired
    PdfService pdfService;

    @GetMapping("/getAllRecipes")
    @ResponseBody
    public List<RecetteDTO> getAll(){
        return recetteDTOService.getAllRecipes();
    }

    @GetMapping("/getRecipesByUserId/{id}")
    @ResponseBody
    public List<RecetteDTO> getAllRecipesByUserId(@PathVariable Long id){
        return recetteDTOService.getRecipesByUserId(id);
    }

    @GetMapping("/getRecipe/{id}")
    @ResponseBody
    public RecetteDTO getRecipe(@PathVariable Long id){
        return recetteDTOService.getRecipeById(id);
    }

    @PostMapping("/newRecipe")
    public Long createRecipe(@RequestBody RecetteDTO recetteDTO) throws IOException {
        return recetteDTOService.createRecipeAndDetailsFromRecipeDTO(recetteDTO);
    }

    @PutMapping("/updateRecipe")
    public Long updateRecipe(@RequestBody RecetteDTO recetteDTO) throws IOException {
        return recetteDTOService.updateRecipe(recetteDTO);
    }

    @DeleteMapping("/deleteRecipe/{id}")
    public void deleteRecipe(@PathVariable Long id){
        recetteDTOService.deleteRecipeByRecipeId(id);
    }

    @GetMapping("/getRecipePdf/{id}")
    public ResponseEntity<byte[]> getRecipePdf(@PathVariable Long id) throws Exception {
        byte[] pdf = pdfService.genererPDF(recetteDTOService.getRecipeById(id));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        //changer nom
        headers.setContentDisposition(ContentDisposition.inline().filename("recipe.pdf").build());

        return ResponseEntity.ok().headers(headers).body(pdf);
    }
}
