package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Identifiant;
import com.cpweb.backend.repositories.IdentifiantRepository;
import com.cpweb.backend.service.IdentifiantDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ident")
@CrossOrigin()
public class IdentifiantController {

    @Autowired
    IdentifiantRepository repo;
    @Autowired
    private IdentifiantDTOService identifiantDTOService;

    @PostMapping("/newIdent")
    public void createIdentifiant(@RequestBody Identifiant identifiant){
        repo.save(identifiant);
    }

    @PostMapping("/connexion/{courriel}/{motDePasse}")
    public boolean connecter(@PathVariable String courriel, @PathVariable String motDePasse){
        return identifiantDTOService.login(courriel, motDePasse);
    }

    @GetMapping("/connexion2")
    public boolean connecter2(@RequestParam String courriel, @RequestParam String motDePasse){
        return identifiantDTOService.login(courriel, motDePasse);
    }


}
