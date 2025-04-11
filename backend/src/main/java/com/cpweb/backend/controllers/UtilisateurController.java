package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.models.UtilisateurDTO;
import com.cpweb.backend.service.UtilisateurDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
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
    public UtilisateurDTO getUtilisateurById(@PathVariable Long id){
        return utilisateurDTOService.getUtilisateurById(id);
    }

    @GetMapping("/getUtilisateurByNom/{nomAffichage}")
    @ResponseBody
    public UtilisateurDTO getUtilisateurByNomAffichage(@PathVariable String nomAffichage){
        return utilisateurDTOService.getUtilisateurByNomAffichage(nomAffichage);
    }


    //Intéressant pour admin, mais manque de temps
    /*
    @GetMapping("/getAllUtilisateur")
    @ResponseBody
    public List<Utilisateur> getAllUtilisateur(){
        return repo.findAll();
    }
     */
}
