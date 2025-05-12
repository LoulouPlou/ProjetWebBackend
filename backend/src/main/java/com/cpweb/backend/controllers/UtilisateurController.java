package com.cpweb.backend.controllers;

import com.cpweb.backend.models.RecetteDTO;
import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.models.UtilisateurDTO;
import com.cpweb.backend.service.UtilisateurDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/utilisateur")
@CrossOrigin()
public class UtilisateurController {

    @Autowired
    UtilisateurDTOService utilisateurDTOService;

    @PostMapping("/newUser")
    public Long createUser(@RequestBody UtilisateurDTO utilisateurDTO){
        return utilisateurDTOService.createUser(utilisateurDTO);
    }

    @GetMapping("/getUser/{id}")
    @ResponseBody
    public UtilisateurDTO getUtilisateur(@PathVariable Long id){
        return utilisateurDTOService.getUtilisateurById(id);
    }

    @GetMapping("/getUtilisateurByNom/{nomAffichage}")
    @ResponseBody
    public UtilisateurDTO getUtilisateurByNomAffichage(@PathVariable String nomAffichage){
        return utilisateurDTOService.getUtilisateurByNomAffichage(nomAffichage);
    }

    @PutMapping("/updateProfil")
    public Long updateProfil(@RequestBody UtilisateurDTO utilisateurDTO) throws IOException {
        return utilisateurDTOService.updateProfil( utilisateurDTO);
    }

}
