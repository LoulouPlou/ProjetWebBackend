package com.cpweb.backend.service;

import com.cpweb.backend.models.*;
import com.cpweb.backend.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetteService {
    private final RecetteRepository recetteRepository;

    public RecetteService(RecetteRepository recetteRepository, TagRecetteRepository tagRecetteRepository, TagRepository tagRepository, IngredientRecetteRepository ingredientRecetteRepository, InstructionRepository instructionRepository) {
        this.recetteRepository = recetteRepository;
    }

    public Long createRecipe(Recette recipe){
        return recetteRepository.save(recipe).getId();
    }
}
