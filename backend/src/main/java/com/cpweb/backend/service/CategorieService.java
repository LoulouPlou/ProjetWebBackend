package com.cpweb.backend.service;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public void createCategory(Categorie categorie) {
        categorie.setId(null);
        categorieRepository.save(categorie);
    }

    public void updateCategory(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(Integer id) {
        return categorieRepository.getCategorieById(id);
    }
}
