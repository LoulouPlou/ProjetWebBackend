package com.cpweb.backend.repositories;


import java.util.List;
import com.cpweb.backend.models.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "unite", path = "unite")
public interface UniteRepository extends JpaRepository<Unite, Integer> {
    public Unite findUniteById(int id);

    //un peu inutile i think
    public List<Unite> findUniteByUniteNom(String uniteNom);


}
