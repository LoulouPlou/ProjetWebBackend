package com.cpweb.backend.models;

import java.util.ArrayList;
import java.util.List;

public class RecetteDTO {

    private Long id;
    private String nomRecette;
    private Integer tempsPrep;
    private Integer tempsCuisson;
    private Integer nbrPortion;
    private String imageUrl;
    private Utilisateur user;
    private Categorie categorie;
    private List<Tag> selectedTags = new ArrayList<>();
    private List<TagRecette> tags = new ArrayList<>();
    private List<IngredientRecetteDTO> ingredients = new ArrayList<>();
    private List<Instruction> etapes = new ArrayList<>();


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

    public List<Tag> getSelectedTags() {
        return selectedTags;
    }

    public void setSelectedTags(List<Tag> selectedTags) {
        this.selectedTags = selectedTags;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<TagRecette> getTags() {
        return tags;
    }

    public void setTags(List<TagRecette> tags) {
        this.tags = tags;
    }

    public List<IngredientRecetteDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientRecetteDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Instruction> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Instruction> etapes) {
        this.etapes = etapes;
    }
}
