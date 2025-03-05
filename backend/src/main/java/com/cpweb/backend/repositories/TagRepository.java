package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
