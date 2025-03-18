package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.Recette;
import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.repositories.IngredientRepository;
import com.cpweb.backend.repositories.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recette")
@CrossOrigin()
public class RecetteController {

    @Autowired
    RecetteRepository repo;

    @PostMapping("/newRecipe")
    public Recette createRecipe(@RequestBody Recette recette){
        repo.save(recette);

        return recette;
    }


    @GetMapping("/getRecetteById")
    @ResponseBody
    public Recette getRecetteById(long id){
        return repo.findRecetteById(id);
    }
    @GetMapping("/getRecetteByNomRecette")
    @ResponseBody
    public Recette getRecetteByNomRecette(String nomRecette){
        return repo.findRecetteByNomRecette(nomRecette);
    }

    @GetMapping("/getRecetteByUser")
    @ResponseBody
    public List<Recette> getRecetteByUser(Utilisateur utilisateur){
        return repo.findRecetteByUser(utilisateur);
    }

    @GetMapping("/getRecetteByCategorie")
    @ResponseBody
    public List<Recette> getRecetteByCategorie(Categorie categorie){
        return repo.findRecetteByCategorie(categorie);
    }
}
