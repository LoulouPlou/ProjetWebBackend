package com.cpweb.backend.service;

import com.cpweb.backend.models.Tag;
import com.cpweb.backend.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public void createTag(Tag tag) {
        tagRepository.save(tag);
    }
}
