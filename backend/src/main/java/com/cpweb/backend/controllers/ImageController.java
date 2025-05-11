package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Image;
import com.cpweb.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Image img = imageService.getImage(id);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(img.getType()))
                .body(img.getImageData());
    }
}
