package com.cpweb.backend;

import com.cpweb.backend.models.Recette;
import com.cpweb.backend.models.RecetteDTO;
import com.cpweb.backend.repositories.*;
import com.cpweb.backend.service.RecetteDTOService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class RecetteDTOTest {

    @Mock
    private RecetteRepository recetteRepository;

    @Mock
    private TagRecetteRepository tagRecetteRepository;

    @Mock
    private IngredientRecetteRepository ingredientRecetteRepository;

    @Mock
    private InstructionRepository instructionRepository;

    @Mock
    private IngredientRepository ingredientRepository;

    @Mock
    private UniteRepository uniteRepository;

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private RecetteDTOService recetteDTOService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRecipes(){

        // Arrange
        Recette recette = new Recette();

        List<Recette> list = Arrays.asList(recette);

        when(recetteRepository.findAll()).thenReturn(list);

        // Act

        // Assert


    }
}
