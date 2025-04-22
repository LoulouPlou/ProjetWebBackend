package com.cpweb.backend.controllers;

import com.cpweb.backend.models.InscriptionDTO;
import com.cpweb.backend.service.InscriptionDTOService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class InscriptionController {
    private final InscriptionDTOService inscriptionDTOService;

    public InscriptionController(InscriptionDTOService inscriptionDTOService) {
        this.inscriptionDTOService = inscriptionDTOService;
    }


    @PostMapping("/Inscription")
    public ResponseEntity<Long> inscrireUtilisateur(@RequestBody InscriptionDTO inscriptionDTO){
        Long id = inscriptionDTOService.inscrireNouvelUtilisateur(inscriptionDTO);
        return ResponseEntity.ok(id);
    }

}
