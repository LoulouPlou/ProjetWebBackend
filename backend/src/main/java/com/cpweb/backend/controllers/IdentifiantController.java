package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Identifiant;
import com.cpweb.backend.repositories.IdentifiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ident")
@CrossOrigin()
public class IdentifiantController {

    @Autowired
    IdentifiantRepository repo;

    @PostMapping("/newIdent")
    public void createIdentifiant(@RequestBody Identifiant identifiant){
        repo.save(identifiant);
    }

    /*
    // login? à voir plus tard...
    public boolean compIdentifiant(Identifiant identifiant){
        repo.equals(identifiant);

        return false;
    }
    */
    // no get pour afficher
}
