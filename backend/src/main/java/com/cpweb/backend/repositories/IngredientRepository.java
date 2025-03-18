package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ingredient", path = "ingredient")
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    public Ingredient findIngredientById(long id);

    public Ingredient findIngredientByIngredientNom(String nom);


}
