package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin()
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/getIngredientByNom")
    @ResponseBody
    public Ingredient getIngredientByNom(String name){
        return ingredientService.getIngredientByName(name);
    }

    @GetMapping("/getAllIngredient")
    @ResponseBody
    public List<Ingredient> getAllIngredient(){
        return ingredientService.findAll();
    }

    @PostMapping("/newIngredient")
    public void addIngredient(@RequestBody Ingredient ingredient){
        ingredientService.createIngredient(ingredient);
    }
}
