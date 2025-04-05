package com.cpweb.backend.service;

import com.cpweb.backend.models.Unite;
import com.cpweb.backend.repositories.UniteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniteService {
    private final UniteRepository uniteRepository;

    public UniteService(UniteRepository uniteRepository) {
        this.uniteRepository = uniteRepository;
    }

    public List<Unite> getAllUnits() {
        return uniteRepository.findAll();
    }
}
