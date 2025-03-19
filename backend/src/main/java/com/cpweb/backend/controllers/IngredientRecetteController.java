package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.IngredientRecette;
import com.cpweb.backend.models.Recette;
import com.cpweb.backend.repositories.IngredientRecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientRecette")
@CrossOrigin()
public class IngredientRecetteController {
    @Autowired
    IngredientRecetteRepository repo;

    @GetMapping("/getIngredientRecetteById")
    @ResponseBody
    public IngredientRecette getIngredientRecetteById(long id){
        return repo.findIngredientRecetteById(id);
    }


    @GetMapping("/getIngredientRecetteByRecette")
    @ResponseBody
    public List<IngredientRecette> getIngredientRecetteByRecette(Recette recette){
        return repo.findIngredientRecetteByRecette(recette);
    }

    @GetMapping("/getAllIngredientRecette")
    @ResponseBody
    public List<IngredientRecette> getAllIngredientRecette(){
        return repo.findAll();
    }
}
