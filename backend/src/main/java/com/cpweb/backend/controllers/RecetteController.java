package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Recette;
import com.cpweb.backend.models.RecetteDTO;
import com.cpweb.backend.service.RecetteDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recette")
@CrossOrigin()
public class RecetteController {

    @Autowired
    RecetteDTOService recetteDTOService;

    @GetMapping("/getAllRecipes")
    @ResponseBody
    public List<RecetteDTO> getAll(){
        return recetteDTOService.getAllRecipes();
    }

    @GetMapping("/getRecipe/{id}")
    public RecetteDTO getRecipe(@PathVariable Long id){
        return recetteDTOService.getRecipeById(id);
    }

    @PostMapping("/newRecipe")
    public Long createRecipe(@RequestBody RecetteDTO recetteDTO){
        return recetteDTOService.createRecipeAndDetailsFromRecipeDTO(recetteDTO);
    }
}
