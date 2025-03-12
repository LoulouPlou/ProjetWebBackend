package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Recette;
import com.cpweb.backend.repositories.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
