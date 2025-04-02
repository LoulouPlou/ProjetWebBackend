package com.cpweb.backend.service;

import com.cpweb.backend.models.*;
import com.cpweb.backend.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetteService {
    private final RecetteRepository recetteRepository;

    private final TagRecetteRepository tagRecetteRepository;

    private final TagRepository tagRepository;

    private final IngredientRecetteRepository ingredientRecetteRepository;

    private final InstructionRepository instructionRepository;


    public RecetteService(RecetteRepository recetteRepository, TagRecetteRepository tagRecetteRepository, TagRepository tagRepository, IngredientRecetteRepository ingredientRecetteRepository, InstructionRepository instructionRepository) {
        this.recetteRepository = recetteRepository;
        this.tagRecetteRepository = tagRecetteRepository;
        this.tagRepository = tagRepository;
        this.ingredientRecetteRepository = ingredientRecetteRepository;
        this.instructionRepository = instructionRepository;
    }

    public List<RecetteDTO> getAllRecipes(){
        List<RecetteDTO> listeRecetteDetails = new ArrayList<>();

        List<Recette> listeRecette = recetteRepository.findAll();

        for (Recette recette : listeRecette){
            RecetteDTO recetteDetails = new RecetteDTO();
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
                recetteDetails.getIngredients().add(ingredientRecette.getQuantite() + " " + unite.getUniteNom() + " "+ ingredient.getIngredientNom());
            }

            List<Instruction> listeInstruction = instructionRepository.findInstructionByRecette(recette);
            for (Instruction instruction : listeInstruction){
                recetteDetails.getEtapes().add(instruction.getNumEtape()+". " + instruction.getDescription());
            }

            listeRecetteDetails.add(recetteDetails);
        }
        return listeRecetteDetails;
    }

    public RecetteDTO getRecipeById(Long recetteId){

        Recette recette = recetteRepository.findRecetteById(recetteId);

        RecetteDTO recetteDetails = new RecetteDTO();
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
            recetteDetails.getIngredients().add(ingredientRecette.getQuantite() + " " + unite.getUniteNom() + " "+ ingredient.getIngredientNom());
        }
        List<Instruction> listeInstruction = instructionRepository.findInstructionByRecette(recette);
        for (Instruction instruction : listeInstruction){
            recetteDetails.getEtapes().add(instruction.getNumEtape()+". " + instruction.getDescription());
        }

        return recetteDetails;
    }
}
