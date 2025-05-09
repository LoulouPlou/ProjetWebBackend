package com.cpweb.backend.controllers;

import com.cpweb.backend.DTO.Connexion;
import com.cpweb.backend.DTO.Inscription;
import com.cpweb.backend.DTO.ReponseAuthentificaton;
import com.cpweb.backend.models.IdentifiantDTO;
import com.cpweb.backend.models.UtilisateurDTO;
import com.cpweb.backend.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authentification")
@CrossOrigin(origins = "*")
public class AuthentificationController {
    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping("/connexion")
    public ReponseAuthentificaton connexion(@RequestBody Connexion connexion){
        return authentificationService.connexion(connexion);
    }

    @PostMapping("/inscription")
    public ReponseAuthentificaton inscription(@RequestBody Inscription inscription){
        return authentificationService.inscription(inscription);
    }

    @PutMapping("/updateProfil")
    public Long updateProfil(@RequestBody UtilisateurDTO utilisateurDTO){
        return authentificationService.updateProfil( utilisateurDTO);
    }


}
