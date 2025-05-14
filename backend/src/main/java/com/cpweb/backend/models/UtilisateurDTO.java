package com.cpweb.backend.models;

public class UtilisateurDTO {
    private Long id;
    private String prenom;
    private String nom;
    private String nomAffichage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomAffichage() {
        return nomAffichage;
    }

    public void setNomAffichage(String nomAffichage) {
        this.nomAffichage = nomAffichage;
    }

    public UtilisateurDTO(){}

    public UtilisateurDTO(long id, String prenom, String nom, String nomAffichage){
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.nomAffichage = nomAffichage;
    }
}
