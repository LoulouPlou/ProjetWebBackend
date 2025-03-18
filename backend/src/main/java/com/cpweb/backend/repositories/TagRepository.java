package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
public interface TagRepository extends JpaRepository<Tag, Integer> {
    public Tag findTagById(long id);

    public Tag findTagByTagNom(String tagNom);


}
