/*package com.cpweb.backend;

import com.cpweb.backend.models.UtilisateurDTO;
import com.cpweb.backend.repositories.UtilisateurRepository;
import com.cpweb.backend.service.UtilisateurDTOService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserTest {

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurDTOService utilisateurDTOService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void updateProfilTest() throws IOException {
        //ARRANGE
        UtilisateurDTO u1 = new UtilisateurDTO(1,"Sarah", "Charef", "SarahCharef");
        u1.setNomAffichage("Meow");

        when(utilisateurRepository.save(u1).thenReturn(u1));
        when(utilisateurRepository.findAll().thenReturn(List.of(
                new UtilisateurDTO(0, "Leia", "Plourde", "LeiaPlourde"), u1
        )));

        utilisateurDTOService.updateProfil(u1);
        String result = utilisateurDTOService.getAllUsers().get(1).getNomAffichage();

        assertEquals("Meow", result);
    }


}*/
