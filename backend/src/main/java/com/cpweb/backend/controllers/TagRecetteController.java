package com.cpweb.backend.controllers;

import com.cpweb.backend.models.TagRecette;
import com.cpweb.backend.service.TagRecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
@CrossOrigin()
public class TagRecetteController {

    @Autowired
    TagRecetteService tagRecetteService;

    @PostMapping("/linktagtorecipe")
    public void createTagRecipe(@RequestBody TagRecette tagRecette){
        tagRecetteService.createTagRecipe(tagRecette);
    }
}
