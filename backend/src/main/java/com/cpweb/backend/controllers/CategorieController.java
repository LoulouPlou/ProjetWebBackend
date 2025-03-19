package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    //Je n'ai pas mis en liste car il n'y pas de doublon possible
    //dans ce cas et il y a un nombre restreint de categories

    //Je sais pas si le response body est necessaire, donc a effacer si oui

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

    @GetMapping("/getAllCategorie")
    @ResponseBody
    public List<Categorie> getAllCategorie(){
        return repo.findAll();
    }

}
