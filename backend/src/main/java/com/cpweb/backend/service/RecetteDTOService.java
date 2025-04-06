package com.cpweb.backend.service;

import com.cpweb.backend.models.*;
import com.cpweb.backend.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetteDTOService {
    private final RecetteRepository recetteRepository;

    private final TagRecetteRepository tagRecetteRepository;

    private final IngredientRecetteRepository ingredientRecetteRepository;

    private final InstructionRepository instructionRepository;

    private final TagRepository tagRepository;

    private final IngredientRepository ingredientRepository;

    private final CategorieRepository categorieRepository;

    private final UniteRepository uniteRepository;


    public RecetteDTOService(RecetteRepository recetteRepository, TagRecetteRepository tagRecetteRepository, TagRepository tagRepository, IngredientRecetteRepository ingredientRecetteRepository, InstructionRepository instructionRepository, TagRepository tagRepository1, IngredientRepository ingredientRepository, CategorieRepository categorieRepository, UniteRepository uniteRepository) {
        this.recetteRepository = recetteRepository;
        this.tagRecetteRepository = tagRecetteRepository;
        this.ingredientRecetteRepository = ingredientRecetteRepository;
        this.instructionRepository = instructionRepository;
        this.tagRepository = tagRepository;
        this.ingredientRepository = ingredientRepository;
        this.categorieRepository = categorieRepository;
        this.uniteRepository = uniteRepository;
    }

    public Long createRecipeAndDetailsFromRecipeDTO(RecetteDTO recetteDTO) {
        Recette recipe = recipeDtoToRecipe(recetteDTO);

        List<Instruction> instructions = new ArrayList<>(recetteDTO.getEtapes());
        instructionRepository.saveAll(instructions);

        List<TagRecette> tags = new ArrayList<>(recetteDTO.getTags());
        tagRecetteRepository.saveAll(tags);

        List<IngredientRecetteDTO> ingredients = new ArrayList<>(recetteDTO.getIngredients());
        for (IngredientRecetteDTO ingredient : ingredients) {
            IngredientRecette recipeIngredient = new IngredientRecette();

            Ingredient ingredientObject = ingredientRepository.findIngredientByIngredientNom(ingredient.getIngredientNom());

            if (ingredientObject != null) {
                recipeIngredient.setIngredient(ingredientObject);
            } else {
                Ingredient newIngredient = new Ingredient();
                newIngredient.setIngredientNom(ingredient.getIngredientNom());
                ingredientRepository.save(newIngredient);

                recipeIngredient.setIngredient(newIngredient);
            }

            recipeIngredient.setQuantite(ingredient.getQuantite());
            recipeIngredient.setUnite(uniteRepository.findUniteByUniteNom(ingredient.getUniteNom()));
            recipeIngredient.setRecette(recipe);
            ingredientRecetteRepository.save(recipeIngredient);
        }

        return recetteRepository.save(recipe).getId();
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

        return recipeToRecipeDTO(recipe);
    }

    public List<RecetteDTO> transformRecipeListIntoRecipeDtoList(List<Recette> recipes){
        List<RecetteDTO> recipeListWithDetails = new ArrayList<>();

        for (Recette recipe : recipes){
            recipeListWithDetails.add(recipeToRecipeDTO(recipe));
        }

        return recipeListWithDetails;
    }

    public RecetteDTO recipeToRecipeDTO(Recette recipe){
        RecetteDTO recipeWithDetails = new RecetteDTO();

        recipeWithDetails.setId(recipe.getId());
        recipeWithDetails.setNomRecette(recipe.getNomRecette());
        recipeWithDetails.setCategorie(recipe.getCategorie());
        recipeWithDetails.setTempsPrep(recipe.getTempsPrep());
        recipeWithDetails.setTempsCuisson(recipe.getTempsCuisson());
        recipeWithDetails.setImageUrl(recipe.getImageUrl());
        recipeWithDetails.setNbrPortion(recipe.getNbrPortion());
        recipeWithDetails.setTags(tagRecetteRepository.findTagRecetteByRecette(recipe));
        recipeWithDetails.setEtapes(instructionRepository.findInstructionByRecette(recipe));
        //recipeWithDetails.setIngredients(ingredientRecetteRepository.findIngredientRecetteByRecette(recipe));

        return recipeWithDetails;
    }

    public Recette recipeDtoToRecipe(RecetteDTO recetteDTO){
        Recette recipe = new Recette();

        recipe.setNomRecette(recetteDTO.getNomRecette());
        recipe.setCategorie(recetteDTO.getCategorie());
        recipe.setTempsPrep(recetteDTO.getTempsPrep());
        recipe.setTempsCuisson(recetteDTO.getTempsCuisson());
        recipe.setImageUrl(recetteDTO.getImageUrl());
        recipe.setNbrPortion(recetteDTO.getNbrPortion());

        return recipe;
    }
}
