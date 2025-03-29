package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.Recette;
import com.cpweb.backend.models.TagRecette;
import com.cpweb.backend.repositories.IngredientRepository;
import com.cpweb.backend.repositories.TagRecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@CrossOrigin()
public class TagRecetteController {

    @Autowired
    TagRecetteRepository repo;

    @PostMapping("/linktagtorecipe")
    public TagRecette createTagRecipe(@RequestBody TagRecette tagRecette){
        repo.save(tagRecette);

        return tagRecette;
    }

    @GetMapping("/getTagRecetteById")
    @ResponseBody
    public TagRecette getTagRecetteById(long id){
        return repo.findTagRecetteById(id);
    }

    @GetMapping("/getTagRecetteByRecette")
    @ResponseBody
    public List<TagRecette> getTagRecetteByRecette(Recette recette){
        return repo.findTagRecetteByRecette(recette);
    }

    /*
    @GetMapping("/getAllTagRecette")
    @ResponseBody
    public List<TagRecette> getAllTagRecette(){
        return repo.findAll();
    }
    */
}
