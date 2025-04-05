package com.cpweb.backend.service;

import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public void createIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredientByName(String name) {
        return ingredientRepository.findIngredientByIngredientNom(name);
    }
}
