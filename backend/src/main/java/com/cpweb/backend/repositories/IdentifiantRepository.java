package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Identifiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentifiantRepository extends JpaRepository<Identifiant, Long> {
}
