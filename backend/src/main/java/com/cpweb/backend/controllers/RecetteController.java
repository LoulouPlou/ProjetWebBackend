package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Recette;
import com.cpweb.backend.models.RecetteDTO;
import com.cpweb.backend.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recette")
@CrossOrigin()
public class RecetteController {

    @Autowired
    RecetteService recetteService;

    @GetMapping("/getAllRecipes")
    @ResponseBody
    public List<RecetteDTO> getAll(){
        return recetteService.getAllRecipes();
    }

    @GetMapping("/getRecipe/{id}")
    public RecetteDTO getRecipe(@PathVariable Long id){
        return recetteService.getRecipeById(id);
    }

    @PostMapping("/newRecipe")
    public Long createRecipe(@RequestBody Recette recette){
        return recetteService.createRecipe(recette);
    }
}
