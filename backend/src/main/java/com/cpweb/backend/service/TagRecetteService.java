package com.cpweb.backend.service;

import com.cpweb.backend.models.TagRecette;
import com.cpweb.backend.repositories.TagRecetteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagRecetteService {
    private final TagRecetteRepository tagRecetteRepository;

    public TagRecetteService(TagRecetteRepository tagRecetteRepository) {
        this.tagRecetteRepository = tagRecetteRepository;
    }

    public List<TagRecette> findAll() {
        return tagRecetteRepository.findAll();
    }

    public void createTagRecipe(TagRecette tagRecette) {
        tagRecetteRepository.save(tagRecette);
    }
}
