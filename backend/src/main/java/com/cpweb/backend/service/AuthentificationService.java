package com.cpweb.backend.service;

import com.cpweb.backend.DTO.Connexion;
import com.cpweb.backend.DTO.Inscription;
import com.cpweb.backend.DTO.ReponseAuthentificaton;
import com.cpweb.backend.models.Identifiant;
import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.repositories.IdentifiantRepository;
import com.cpweb.backend.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {
    @Autowired
    private IdentifiantRepository identifiantRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public ReponseAuthentificaton connexion(Connexion connexion){
        Identifiant identifiant = identifiantRepository.findIdentifiantByCourriel(connexion.getCourriel());

        if(identifiant == null){
            return new ReponseAuthentificaton(false, "Le courriel est introuvable" ,null, null);
        }

        return new ReponseAuthentificaton(true, "Connexion réussie", identifiant.getUser().getId(),identifiant.getUser().getNomAffichage());
    }

    public  ReponseAuthentificaton inscription(Inscription inscription){
        if (identifiantRepository.existsByCourriel(inscription.getCourriel())){
            return new ReponseAuthentificaton(false, "L'email existe déjà", null,null);
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(inscription.getNom());
        utilisateur.setPrenom(inscription.getPrenom());
        utilisateur.setNomAffichage(inscription.getNomAffichage());

        Identifiant identifiant = new Identifiant();
        identifiant.setCourriel(inscription.getCourriel());
        identifiant.setMotDePasse(inscription.getMotDePasse());
        identifiant.setUser(utilisateur);

        utilisateurRepository.save(utilisateur);
        identifiantRepository.save(identifiant);

        return new ReponseAuthentificaton(true,"Un nouveau utilisateur a été créer avec succès!! Yippie", utilisateur.getId(), utilisateur.getNomAffichage());
    }

}
