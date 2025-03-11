package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepository extends JpaRepository<Recette, Long> {
}
