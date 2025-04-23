package com.cpweb.backend.service;

import com.cpweb.backend.models.Identifiant;
import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.models.UtilisateurDTO;
import com.cpweb.backend.repositories.IdentifiantRepository;
import com.cpweb.backend.repositories.UtilisateurRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentifiantDTOService {
    private final BCryptPasswordEncoder motDePasseEncoder = new BCryptPasswordEncoder();
    private final IdentifiantRepository identifiantRepository;
    private final UtilisateurRepository utilisateurRepository;


    public IdentifiantDTOService(IdentifiantRepository identifiantRepository, UtilisateurRepository utilisateurRepository) {
        this.identifiantRepository = identifiantRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public boolean login (String courriel, String frontEndMdp){
        Identifiant identifiant = identifiantRepository.findIdentifiantByCourriel(courriel);

        return motDePasseEncoder.matches(frontEndMdp, identifiant.getMotDePasse());
    }

    public List<Identifiant> findAllIdentifiant(){
        return  identifiantRepository.findAll();
    }

    public String inscrireIdentifiant(String motDePasse){
        return motDePasseEncoder.encode(motDePasse);
    }

    public List<Identifiant> insererListIdentifiant(List<Identifiant> liste){
        return identifiantRepository.saveAll(liste);
    }
}