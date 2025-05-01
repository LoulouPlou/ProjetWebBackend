package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Identifiant;
import com.cpweb.backend.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "identifiant", path = "identifiant")
public interface IdentifiantRepository extends JpaRepository<Identifiant, Long> {
    public Identifiant findIdentifiantByCourriel(String courriel);
    boolean existsByCourriel(String courriel);

}