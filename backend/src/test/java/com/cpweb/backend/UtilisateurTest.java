/*package com.cpweb.backend;



import com.cpweb.backend.models.Utilisateur;
import com.cpweb.backend.models.UtilisateurDTO;
import com.cpweb.backend.repositories.UtilisateurRepository;
import com.cpweb.backend.service.UtilisateurDTOService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UtilisateurTest {

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurDTOService utilisateurDTOService;

    @BeforeEach
    public void setUpd(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void updateUtilisateurTest() throws IOException {
        UtilisateurDTO utilisateur1 = new UtilisateurDTO(1L, "Moew", "Meow", "MeowPremium");
        UtilisateurDTO utilisateur2 = new UtilisateurDTO(2L, "Woof", "Warf", "WarfPremium");
        UtilisateurDTO utilisateur3 = new UtilisateurDTO(3L, "Sarah", "Charef", "SarahPremium");

        List<UtilisateurDTO> utilisateurDTOList = Arrays.asList(utilisateur1, utilisateur2, utilisateur3);

        when(utilisateurRepository.findAll()).thenReturn(utilisateurDTOList);
        when(utilisateurRepository.save(utilisateur3)).thenReturn(utilisateur3);

        utilisateur3.setNomAffichage("Test");
        utilisateurDTOService.updateProfil(utilisateur3);
        String result = utilisateurDTOService.getUtilisateurById(3L);
        //Abandonne


    }
}*/
