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

    private final IngredientRecetteRepository ingredientRecetteRepository;

    private final InstructionRepository instructionRepository;


    public RecetteService(RecetteRepository recetteRepository, TagRecetteRepository tagRecetteRepository, TagRepository tagRepository, IngredientRecetteRepository ingredientRecetteRepository, InstructionRepository instructionRepository) {
        this.recetteRepository = recetteRepository;
        this.tagRecetteRepository = tagRecetteRepository;
        this.ingredientRecetteRepository = ingredientRecetteRepository;
        this.instructionRepository = instructionRepository;
    }

    public List<RecetteDTO> getAllRecipes(){

        List<Recette> recipeList = recetteRepository.findAll();

        return transformRecipeListIntoRecipeDtoList(recipeList);
    }

    public List<RecetteDTO> getAllRecipesByCategory(Categorie categorie){

        List<Recette> recipeList = recetteRepository.findRecetteByCategorie(categorie);

        return transformRecipeListIntoRecipeDtoList(recipeList);
    }

    public RecetteDTO getRecipeById(Long recetteId){

        Recette recipe = recetteRepository.findRecetteById(recetteId);

        RecetteDTO recipeWithDetails = new RecetteDTO();
        recipeWithDetails.setId(recipe.getId());
        recipeWithDetails.setNomRecette(recipe.getNomRecette());
        recipeWithDetails.setCategorie(recipe.getCategorie());
        recipeWithDetails.setTempsPrep(recipe.getTempsPrep());
        recipeWithDetails.setTempsCuisson(recipe.getTempsCuisson());
        recipeWithDetails.setImageUrl(recipe.getImageUrl());
        recipeWithDetails.setNbrPortion(recipe.getNbrPortion());
        List<TagRecette> listeTagRecette = tagRecetteRepository.findTagRecetteByRecette(recipe);
        for (TagRecette tagRecette : listeTagRecette){
            Tag tag = tagRecette.getTag();
            recipeWithDetails.getTags().add(tag.getTagNom());
        }
        List<IngredientRecette> listeIngredientRecette = ingredientRecetteRepository.findIngredientRecetteByRecette(recipe);
        for (IngredientRecette ingredientRecette : listeIngredientRecette){
            Ingredient ingredient = ingredientRecette.getIngredient();
            Unite unite = ingredientRecette.getUnite();
            recipeWithDetails.getIngredients().add(ingredientRecette.getQuantite() + " " + unite.getUniteNom() + " "+ ingredient.getIngredientNom());
        }
        List<Instruction> listeInstruction = instructionRepository.findInstructionByRecette(recipe);
        for (Instruction instruction : listeInstruction){
            recipeWithDetails.getEtapes().add(instruction.getNumEtape()+". " + instruction.getDescription());
        }

        return recipeWithDetails;
    }

    public List<RecetteDTO> transformRecipeListIntoRecipeDtoList(List<Recette> recipes){
        List<RecetteDTO> recipeListWithDetails = new ArrayList<>();

        for (Recette recipe : recipes){
            RecetteDTO recipeWithDetails = new RecetteDTO();
            recipeWithDetails.setId(recipe.getId());
            recipeWithDetails.setNomRecette(recipe.getNomRecette());
            recipeWithDetails.setCategorie(recipe.getCategorie());
            recipeWithDetails.setTempsPrep(recipe.getTempsPrep());
            recipeWithDetails.setTempsCuisson(recipe.getTempsCuisson());
            recipeWithDetails.setImageUrl(recipe.getImageUrl());
            recipeWithDetails.setNbrPortion(recipe.getNbrPortion());

            List<TagRecette> listeTagRecette = tagRecetteRepository.findTagRecetteByRecette(recipe);
            for (TagRecette tagRecette : listeTagRecette){
                Tag tag = tagRecette.getTag();
                recipeWithDetails.getTags().add(tag.getTagNom());
            }

            List<IngredientRecette> listeIngredientRecette = ingredientRecetteRepository.findIngredientRecetteByRecette(recipe);
            for (IngredientRecette ingredientRecette : listeIngredientRecette){
                Ingredient ingredient = ingredientRecette.getIngredient();
                Unite unite = ingredientRecette.getUnite();
                recipeWithDetails.getIngredients().add(ingredientRecette.getQuantite() + " " + unite.getUniteNom() + " "+ ingredient.getIngredientNom());
            }

            List<Instruction> listeInstruction = instructionRepository.findInstructionByRecette(recipe);
            for (Instruction instruction : listeInstruction){
                recipeWithDetails.getEtapes().add(instruction.getNumEtape()+". " + instruction.getDescription());
            }

            recipeListWithDetails.add(recipeWithDetails);
        }

        return recipeListWithDetails;
    }

    public Long createRecipe(Recette recipe){
        return recetteRepository.save(recipe).getId();
    }
}
