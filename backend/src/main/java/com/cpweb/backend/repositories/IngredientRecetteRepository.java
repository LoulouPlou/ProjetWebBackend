package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.IngredientRecette;
import com.cpweb.backend.models.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "ingredientrecette", path = "ingredientrecette")
public interface IngredientRecetteRepository extends JpaRepository<IngredientRecette, Long> {

    List<IngredientRecette> findIngredientRecetteByRecette(Recette recette);

}
