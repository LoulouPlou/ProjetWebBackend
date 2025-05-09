package com.cpweb.backend.service;
import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.models.UtilisateurDTO;
import com.cpweb.backend.repositories.*;

import com.cpweb.backend.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurDTOService {

    private final UtilisateurRepository utilisateurRepository;


    public UtilisateurDTOService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Long createUser(UtilisateurDTO utilisateurDTO){
        Utilisateur utilisateur = utilisateurDTOToUtilisateur(utilisateurDTO);
        Long utilisateurId = utilisateurRepository.save(utilisateur).getId();
        utilisateur = utilisateurRepository.findUtilisateurById(utilisateurId);

        return utilisateurId;
    }

    public UtilisateurDTO getUtilisateurByNomAffichage(String nomAffichage){
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByNomAffichage(nomAffichage);

        return utilisateurToUtilisateurDTO(utilisateur);
    }

    public UtilisateurDTO utilisateurToUtilisateurDTO(Utilisateur utilisateur){
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();

        utilisateurDTO.setId(utilisateur.getId());
        utilisateurDTO.setNom(utilisateur.getNom());
        utilisateurDTO.setPrenom(utilisateur.getPrenom());
        utilisateurDTO.setNomAffichage(utilisateur.getNomAffichage());

        return utilisateurDTO;
    }

    public Utilisateur utilisateurDTOToUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId(utilisateurDTO.getId());
        utilisateur.setNomAffichage(utilisateurDTO.getNomAffichage());
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());

        return utilisateur;
    }

    public UtilisateurDTO getUtilisateurById(Long utilisateurId){
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(utilisateurId);

        return utilisateurToUtilisateurDTO(utilisateur);
    }

    public Long updateProfil (UtilisateurDTO utilisateurDTO){
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(utilisateurDTO.getId());

        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setNomAffichage(utilisateurDTO.getNomAffichage());

        return utilisateur.getId();
    }

}
