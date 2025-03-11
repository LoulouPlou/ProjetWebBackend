package com.cpweb.backend.models;

import jakarta.persistence.*;

@Entity
public class IngredientRecette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Ingredient ingredient;
    @ManyToOne
    private Recette recette;
    private Float quantite;
    @ManyToOne
    private Unite unite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getQuantite() {
        return quantite;
    }

    public void setQuantite(Float quantite) {
        this.quantite = quantite;
    }
}
