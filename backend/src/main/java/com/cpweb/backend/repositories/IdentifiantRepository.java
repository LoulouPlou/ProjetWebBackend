package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Identifiant;
import com.cpweb.backend.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface IdentifiantRepository extends JpaRepository<Identifiant, Long> {

}
