package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Unite;
import com.cpweb.backend.service.UniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unite")
@CrossOrigin()
public class UniteController {

    @Autowired
    UniteService uniteService;

    @GetMapping("/getAllUnite")
    @ResponseBody
    public List<Unite> getAllUnite(){
        return uniteService.getAllUnits();
    }
}
