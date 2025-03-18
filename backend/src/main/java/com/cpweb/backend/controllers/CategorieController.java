package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    //Je n'ai pas mis en liste car il n'y pas de doublon possible
    //dans ce cas et il y a un nombre restreint de categories

    @Autowired
    CategorieRepository repo;

    @GetMapping("/getCategorieById")
    @ResponseBody
    public Categorie getCategorieById(int id){
        return repo.findCategorieById(id);
    }

    @GetMapping("/getCategorieByName")
    @ResponseBody
    public Categorie getCategorieByCategorieNom(String categorieNom){
        return repo.findCategorieByCategorieNom(categorieNom);
    }

    //getall

}
