package com.cpweb.backend.service;

import com.cpweb.backend.models.IngredientRecette;
import com.cpweb.backend.repositories.IngredientRecetteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientRecetteService {

    private final IngredientRecetteRepository ingredientRecetteRepository;

    public IngredientRecetteService(IngredientRecetteRepository ingredientRecetteRepository) {
        this.ingredientRecetteRepository = ingredientRecetteRepository;
    }

    public List<IngredientRecette> findAll() {
        return ingredientRecetteRepository.findAll();
    }

    public void createIngredientRecipe(IngredientRecette ingredientRecette) {
        ingredientRecetteRepository.save(ingredientRecette);
    }
}
