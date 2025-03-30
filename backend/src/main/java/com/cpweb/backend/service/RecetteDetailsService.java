package com.cpweb.backend.service;

import com.cpweb.backend.repositories.RecetteRepository;
import com.cpweb.backend.repositories.TagRecetteRepository;
import com.cpweb.backend.repositories.TagRepository;

import java.util.List;

public class RecetteDetailsService {
    private final RecetteRepository recetteRepository;

    private final TagRecetteRepository tagRecetteRepository;

    private final TagRepository tagRepository;


    public RecetteDetailsService(RecetteRepository recetteRepository, TagRecetteRepository tagRecetteRepository, TagRepository tagRepository) {
        this.recetteRepository = recetteRepository;
        this.tagRecetteRepository = tagRecetteRepository;
        this.tagRepository = tagRepository;
    }

}
