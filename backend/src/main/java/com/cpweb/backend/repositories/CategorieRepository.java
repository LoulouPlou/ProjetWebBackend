package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "categorie", path = "categorie")
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

    Categorie getCategorieById(Integer categoryId);
}
