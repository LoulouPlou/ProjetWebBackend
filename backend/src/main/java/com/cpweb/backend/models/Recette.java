package com.cpweb.backend.models;

import jakarta.persistence.*;

@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomRecette;
    private Integer tempsPrep;
    private Integer tempsCuisson;
    private Integer nbrPortion;
    private String imageUrl;
    @ManyToOne
    private Utilisateur user;
    @ManyToOne
    private Categorie categorie;

    public Long getId() {
        return id;
    }

    public void setId(Long recetteId) {
        this.id = recetteId;
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
}
