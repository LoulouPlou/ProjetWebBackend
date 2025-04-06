package com.cpweb.backend.models;

public class IngredientRecetteDTO {

    private Long id;
    private String ingredientNom;
    private String uniteNom;
    private Float quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientNom() {
        return ingredientNom;
    }

    public void setIngredientNom(String ingredientNom) {
        this.ingredientNom = ingredientNom;
    }

    public String getUniteNom() {
        return uniteNom;
    }

    public void setUniteNom(String uniteNom) {
        this.uniteNom = uniteNom;
    }

    public Float getQuantite() {
        return quantite;
    }

    public void setQuantite(Float quantite) {
        this.quantite = quantite;
    }
}
