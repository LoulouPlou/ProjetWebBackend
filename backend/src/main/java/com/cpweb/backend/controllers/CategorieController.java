package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
@CrossOrigin()
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @GetMapping("/getAllCategorie")
    @ResponseBody
    public List<Categorie> getAllCategorie(){
        return categorieService.getAllCategories();
    }

    @PostMapping("/newCategorie")
    public void newCategorie(@RequestBody Categorie categorie){
        categorieService.createCategory(categorie);
    }

    @PutMapping("/updateCategorie")
    public void updateCategorie(@RequestBody Categorie categorie){
        categorieService.updateCategory(categorie);
    }
}
