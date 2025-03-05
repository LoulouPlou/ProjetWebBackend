package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.IngredientRecette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRecetteRepository extends JpaRepository<IngredientRecette, Integer> {
}
