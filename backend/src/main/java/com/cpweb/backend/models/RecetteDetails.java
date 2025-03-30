package com.cpweb.backend.models;

import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

public class RecetteDetails {

    private Long id;
    private String nomRecette;
    private Integer tempsPrep;
    private Integer tempsCuisson;
    private Integer nbrPortion;
    private String imageUrl;
    private Utilisateur user;
    private Categorie categorie;
    private List<String> tags = new ArrayList<>();
    private List<String> ingredients = new ArrayList<>();
    private List<String> etapes = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomRecette() {
        return nomRecette;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public Integer getTempsPrep() {
        return tempsPrep;
    }

    public void setTempsPrep(Integer tempsPrep) {
        this.tempsPrep = tempsPrep;
    }

    public Integer getTempsCuisson() {
        return tempsCuisson;
    }

    public void setTempsCuisson(Integer tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }

    public Integer getNbrPortion() {
        return nbrPortion;
    }

    public void setNbrPortion(Integer nbrPortion) {
        this.nbrPortion = nbrPortion;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<String> etapes) {
        this.etapes = etapes;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
