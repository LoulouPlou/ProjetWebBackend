package com.cpweb.backend.controllers;

import com.cpweb.backend.models.InscriptionDTO;
import com.cpweb.backend.service.InscriptionDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/data")
@CrossOrigin()
public class InscriptionController {
    @Autowired
    private InscriptionDTOService inscriptionDTOService;

    public InscriptionController(InscriptionDTOService inscriptionDTOService) {
        this.inscriptionDTOService = inscriptionDTOService;
    }


}
