package com.cpweb.backend.models;

import jakarta.persistence.*;

@Entity
public class TagRecette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Tag tag;
    @ManyToOne
    private Recette recette;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
