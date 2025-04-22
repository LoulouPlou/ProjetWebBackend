package com.cpweb.backend.service;

import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.models.UtilisateurDTO;
import com.cpweb.backend.repositories.IdentifiantRepository;
import com.cpweb.backend.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

@Service
public class IdentifiantDTOService {
    private final IdentifiantRepository identifiantRepository;
    private final UtilisateurRepository utilisateurRepository;


    public IdentifiantDTOService(IdentifiantRepository identifiantRepository, UtilisateurRepository utilisateurRepository) {
        this.identifiantRepository = identifiantRepository;
        this.utilisateurRepository = utilisateurRepository;
    }
}
