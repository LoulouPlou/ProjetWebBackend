package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "utilisateur", path = "utilisateur")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findUtilisateurById(long id);

    Utilisateur findUtilisateurByNomAffichage(String nomAffichage);

}
