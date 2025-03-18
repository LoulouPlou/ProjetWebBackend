package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin()
public class IngredientController {

    @Autowired
    IngredientRepository repo;

    @GetMapping("/getIngredientById")
    @ResponseBody
    public Ingredient getIngredientById(long id){
        return repo.findIngredientById(id);
    }
    @GetMapping("/getIngredientByNom")
    @ResponseBody
    public Ingredient getIngredientByNom(String ingredientNom){
        return repo.findIngredientByIngredientNom(ingredientNom);
    }

    //getall
}
