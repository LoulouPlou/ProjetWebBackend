package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.Recette;
import com.cpweb.backend.models.TagRecette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "tagrecette", path = "tagrecette")
public interface TagRecetteRepository extends JpaRepository<TagRecette, Long> {

    List<TagRecette> findTagRecetteByRecette(Recette recette);

}
