package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "unite", path = "unite")
public interface UniteRepository extends JpaRepository<Unite, Integer> {

    Unite findUniteByUniteNom(String uniteNom);

}
