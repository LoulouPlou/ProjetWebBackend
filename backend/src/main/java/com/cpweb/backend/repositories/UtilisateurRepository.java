package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
