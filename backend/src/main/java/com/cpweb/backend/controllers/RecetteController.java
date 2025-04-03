package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.Recette;
import com.cpweb.backend.models.RecetteDTO;
import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.repositories.RecetteRepository;
import com.cpweb.backend.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recette")
@CrossOrigin()
public class RecetteController {

    @Autowired
    RecetteRepository recetteRepository;

    @PostMapping("/newRecipe")
    public Recette createRecipe(@RequestBody Recette recette){
        recetteRepository.save(recette);

        return recette;
    }

    // AVEC SERVICE
    @Autowired
    RecetteService recetteService;

    @GetMapping("/getAllRecipes")
    public List<RecetteDTO> getAll(){
        return recetteService.getAllRecipes();
    }

    @GetMapping("/getRecipe/{id}")
    public RecetteDTO getRecipe(@PathVariable Long id){
        return recetteService.getRecipeById(id);
    }
}
