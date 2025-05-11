package com.cpweb.backend.models;

import jakarta.persistence.*;


@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tagNom;

    public Tag() {}

    public Tag(int id, String tagNom) {
        this.id = id;
        this.tagNom = tagNom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagNom() {
        return tagNom;
    }

    public void setTagNom(String tagNom) {
        this.tagNom = tagNom;
    }
}
