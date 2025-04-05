package com.cpweb.backend.controllers;

import com.cpweb.backend.models.IngredientRecette;
import com.cpweb.backend.models.Recette;
import com.cpweb.backend.service.IngredientRecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ingredientRecette")
@CrossOrigin()
public class IngredientRecetteController {
    @Autowired
    IngredientRecetteService ingredientRecetteService;

    @GetMapping("/getAllIngredientRecette")
    @ResponseBody
    public List<IngredientRecette> getIngredientRecetteByRecette(Recette recette){
        return ingredientRecetteService.findAll();
    }

    @PostMapping("/newIngredientRecette")
    public List<IngredientRecette> getAllIngredientRecette(){
        return ingredientRecetteService.findAll();
    }
}
