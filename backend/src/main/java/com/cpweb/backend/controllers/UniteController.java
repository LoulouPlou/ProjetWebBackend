package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.Unite;
import com.cpweb.backend.repositories.IngredientRepository;
import com.cpweb.backend.repositories.UniteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unite")
@CrossOrigin()
public class UniteController {

    @Autowired
    UniteRepository repo;

    @GetMapping("/getUniteById")
    @ResponseBody
    public Unite getUniteById(int id){
        return repo.findUniteById(id);
    }
    @GetMapping("/getUniteByUniteNom")
    @ResponseBody
    public List<Unite> getUniteByUniteNom(String uniteNom){
        return repo.findUniteByUniteNom(uniteNom);
    }
}
