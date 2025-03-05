package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.TagRecette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRecetteRepository extends JpaRepository<TagRecette, Integer> {
}
