package com.cpweb.backend;

import com.cpweb.backend.models.Tag;
import com.cpweb.backend.repositories.TagRepository;
import com.cpweb.backend.service.TagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TagTest {

    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private TagService tagService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void updateTagTest() {
        //Arrange
        Tag t1 = new Tag(1
                ,"tag1");
        Tag t2 = new Tag(2,"tag2");
        Tag t3 = new Tag(3,"tag3");

        List<Tag> tagList = Arrays.asList(t1,t2,t3);

        when(tagRepository.findAll()).thenReturn(tagList);
        when(tagRepository.save(t3)).thenReturn(t3);


        // act
        t3.setTagNom("test!");
        tagService.updateTag(t3);
        String result = tagService.getAllTags().get(2).getTagNom();

        // assert
        assertEquals("test!", result);
    }
}
