package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Tag;
import com.cpweb.backend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tag")
@CrossOrigin()
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/getAllTag")
    @ResponseBody
    public List<Tag> getAllTag(){
        return tagService.getAllTags();
    }

    @PostMapping("/newTag")
    public void addTag(@RequestBody Tag tag){
        tagService.createTag(tag);
    }

    @PutMapping("/updateTag")
    public void updateTag(@RequestBody Tag tag){
        tagService.updateTag(tag);
    }
}
