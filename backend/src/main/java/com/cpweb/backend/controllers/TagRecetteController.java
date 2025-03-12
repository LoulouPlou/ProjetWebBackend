package com.cpweb.backend.controllers;

import com.cpweb.backend.models.TagRecette;
import com.cpweb.backend.repositories.TagRecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
