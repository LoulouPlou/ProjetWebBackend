package com.cpweb.backend.DTO;

public class ReponseAuthentificaton {
    private boolean succes;
    private String message;
    private Long utilisateurId;
    private String nomAffichage;

    public ReponseAuthentificaton(boolean succes, String message, Long utilisateurId, String nomAffichage) {
        this.succes = succes;
        this.message = message;
        this.utilisateurId = utilisateurId;
        this.nomAffichage = nomAffichage;
    }

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getNomAffichage() {
        return nomAffichage;
    }

    public void setNomAffichage(String nomAffichage) {
        this.nomAffichage = nomAffichage;
    }
}
