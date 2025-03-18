package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.repositories.IngredientRepository;
import com.cpweb.backend.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin()
public class UtilisateurController {

    @Autowired
    UtilisateurRepository repo;

    @PostMapping("/newUser")
    public Utilisateur createUser(@RequestBody Utilisateur utilisateur){
        repo.save(utilisateur);

        return utilisateur;
    }

    @GetMapping("/getUserById")
    @ResponseBody
    public Utilisateur getUtilisateurById(long id){
        return repo.findUtilisateurById(id);
    }
    @GetMapping("/getUtilisateurByNomAffichage")
    @ResponseBody
    public Utilisateur getUtilisateurByNomAffichage(String nomAffichage){
        return repo.findUtilisateurByNomAffichage(nomAffichage);
    }
}
