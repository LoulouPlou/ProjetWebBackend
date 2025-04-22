package com.cpweb.backend.service;


import com.cpweb.backend.models.Identifiant;
import com.cpweb.backend.models.InscriptionDTO;
import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.models.UtilisateurDTO;
import com.cpweb.backend.repositories.IdentifiantRepository;
import com.cpweb.backend.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

@Service
public class InscriptionDTOService {
    private final IdentifiantRepository identifiantRepository;
    private final UtilisateurRepository utilisateurRepository;


    public InscriptionDTOService(IdentifiantRepository identifiantRepository, UtilisateurRepository utilisateurRepository) {
        this.identifiantRepository = identifiantRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public Long inscrireNouvelUtilisateur(InscriptionDTO inscriptionDTO){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(inscriptionDTO.getUtilisateur().getNom());
        utilisateur.setPrenom(inscriptionDTO.getUtilisateur().getPrenom());
        utilisateur.setNomAffichage(inscriptionDTO.getUtilisateur().getNomAffichage());
        utilisateur = utilisateurRepository.save(utilisateur);


        Identifiant idenifiant = new Identifiant();
        idenifiant.setCourriel(inscriptionDTO.getIdentifiant().getCourriel());
        idenifiant.setMotDePasse(inscriptionDTO.getIdentifiant().getMotDePasse());
        idenifiant.setUser(utilisateur); //Relation
        identifiantRepository.save(idenifiant);

        return utilisateur.getId();

    }
}
