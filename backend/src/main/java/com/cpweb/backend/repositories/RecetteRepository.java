package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.Recette;
import com.cpweb.backend.models.Utilisateur;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "recette", path = "recette")
public interface RecetteRepository extends JpaRepository<Recette, Long> {
    public Recette findRecetteById(long id);

    public Recette findRecetteByNomRecette(String nomRecette);

    public List<Recette> findRecetteByUser (Utilisateur utilisateur);

    public List<Recette> findRecetteByCategorie (Categorie categorie);


}
