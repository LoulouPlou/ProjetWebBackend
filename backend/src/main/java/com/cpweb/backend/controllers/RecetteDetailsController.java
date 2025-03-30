package com.cpweb.backend.controllers;

import com.cpweb.backend.models.*;
import com.cpweb.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recetteDetails")
@CrossOrigin()
public class RecetteDetailsController {
    @Autowired
    RecetteRepository recetteRepository;

    @Autowired
    TagRecetteRepository tagRecetteRepository;

    @Autowired
    InstructionRepository instructionRepository;

    @Autowired
    private IngredientRecetteRepository ingredientRecetteRepository;

    @GetMapping("/allRecipes")
    @ResponseBody
    public List<RecetteDetails> getAllRecipes(){
        List<RecetteDetails> listeRecetteDetails = new ArrayList<>();

        List<Recette> listeRecette = recetteRepository.findAll();

        for (Recette recette : listeRecette){
            RecetteDetails recetteDetails = new RecetteDetails();
            recetteDetails.setId(recette.getId());
            recetteDetails.setNomRecette(recette.getNomRecette());
            recetteDetails.setCategorie(recette.getCategorie());
            recetteDetails.setTempsPrep(recette.getTempsPrep());
            recetteDetails.setTempsCuisson(recette.getTempsCuisson());
            recetteDetails.setImageUrl(recette.getImageUrl());
            recetteDetails.setNbrPortion(recette.getNbrPortion());

            List<TagRecette> listeTagRecette = tagRecetteRepository.findTagRecetteByRecette(recette);
            for (TagRecette tagRecette : listeTagRecette){
                Tag tag = tagRecette.getTag();
                recetteDetails.getTags().add(tag.getTagNom());
            }

            List<IngredientRecette> listeIngredientRecette = ingredientRecetteRepository.findIngredientRecetteByRecette(recette);
            for (IngredientRecette ingredientRecette : listeIngredientRecette){
                Ingredient ingredient = ingredientRecette.getIngredient();
                Unite unite = ingredientRecette.getUnite();
                recetteDetails.getIngredients().add(ingredientRecette.getQuantite() + " " + unite + " "+ ingredient.getIngredientNom());
            }

            List<Instruction> listeInstruction = instructionRepository.findInstructionByRecette(recette);
            for (Instruction instruction : listeInstruction){
                recetteDetails.getEtapes().add(instruction.getNumEtape()+". " + instruction.getDescription());
            }

            listeRecetteDetails.add(recetteDetails);
        }
        return listeRecetteDetails;
    }
}
