package com.cpweb.backend.models;


public class InscriptionDTO {
    private UtilisateurDTO utilisateur;
    private IdentifiantDTO identifiant;

    public UtilisateurDTO getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurDTO utilisateur) {
        this.utilisateur = utilisateur;
    }

    public IdentifiantDTO getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(IdentifiantDTO identifiant) {
        this.identifiant = identifiant;
    }
}