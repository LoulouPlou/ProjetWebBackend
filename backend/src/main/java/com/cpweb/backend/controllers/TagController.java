package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.Tag;
import com.cpweb.backend.repositories.IngredientRepository;
import com.cpweb.backend.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
@CrossOrigin()
public class TagController {

    @Autowired
    TagRepository repo;

    @GetMapping("/getTagById")
    @ResponseBody
    public Tag getTagById(long id){
        return repo.findTagById(id);
    }
    @GetMapping("/getTagByTagNom")
    @ResponseBody
    public Tag getTagByTagNom(String tagNom){
        return repo.findTagByTagNom(tagNom);
    }
}
