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

    private final UtilisateurRepository utilisateurRepository;


    public RecetteDTOService(RecetteRepository recetteRepository, TagRecetteRepository tagRecetteRepository, TagRepository tagRepository, IngredientRecetteRepository ingredientRecetteRepository, InstructionRepository instructionRepository, TagRepository tagRepository1, IngredientRepository ingredientRepository, CategorieRepository categorieRepository, UniteRepository uniteRepository, UtilisateurRepository utilisateurRepository) {
        this.recetteRepository = recetteRepository;
        this.tagRecetteRepository = tagRecetteRepository;
        this.ingredientRecetteRepository = ingredientRecetteRepository;
        this.instructionRepository = instructionRepository;
        this.tagRepository = tagRepository;
        this.ingredientRepository = ingredientRepository;
        this.categorieRepository = categorieRepository;
        this.uniteRepository = uniteRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public Long createRecipeAndDetailsFromRecipeDTO(RecetteDTO recetteDTO) {
        Recette recipe = recipeDtoToRecipe(recetteDTO);
        Long recipeId = recetteRepository.save(recipe).getId();
        recipe = recetteRepository.findRecetteById(recipeId); // qu'il comprenne le id

        List<Instruction> instructions = new ArrayList<>(recetteDTO.getEtapes());
        for (Instruction instruction : instructions){
            instruction.setRecette(recipe);
            instructionRepository.save(instruction);
        }

        List<Tag> tags = new ArrayList<>(recetteDTO.getSelectedTags());
        for (Tag tag : tags){
            TagRecette tagRecette = new TagRecette();
            tagRecette.setTag(tag);
            tagRecette.setRecette(recipe);

            tagRecetteRepository.save(tagRecette);
        }

        List<IngredientRecetteDTO> ingredients = new ArrayList<>(recetteDTO.getIngredients());
        saveIngredientRecetteDTO(ingredients, recipe);

        return recipeId;
    }

    public List<RecetteDTO> getAllRecipes(){

        List<Recette> recipeList = recetteRepository.findAll();

        return transformRecipeListIntoRecipeDtoList(recipeList);
    }

    public List<RecetteDTO> getRecipesByUserId(Long userId){

        List<Recette> recipeList = recetteRepository.findRecetteByUser(utilisateurRepository.findUtilisateurById(userId));

        return transformRecipeListIntoRecipeDtoList(recipeList);
    }

    public List<RecetteDTO> getRecipesByCategory(Categorie categorie){

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

        List<IngredientRecetteDTO> ingredientsDetails = new ArrayList<>();
        List<IngredientRecette> ingredientsRecipe = ingredientRecetteRepository.findIngredientRecetteByRecette(recipe);

        for (IngredientRecette ingredientRecipe : ingredientsRecipe){
            IngredientRecetteDTO ingredientRecetteDTO = new IngredientRecetteDTO();

            ingredientRecetteDTO.setIngredientNom(ingredientRecipe.getIngredient().getIngredientNom());
            ingredientRecetteDTO.setUniteNom(ingredientRecipe.getUnite().getUniteNom());
            ingredientRecetteDTO.setQuantite(ingredientRecipe.getQuantite());

            ingredientsDetails.add(ingredientRecetteDTO);
        }

        recipeWithDetails.setIngredients(ingredientsDetails);

        return recipeWithDetails;
    }

    public Recette recipeDtoToRecipe(RecetteDTO recetteDTO){
        Recette recipe = new Recette();

        recipe.setNomRecette(recetteDTO.getNomRecette());
        recipe.setUser(recetteDTO.getUser());
        recipe.setCategorie(recetteDTO.getCategorie());
        recipe.setTempsPrep(recetteDTO.getTempsPrep());
        recipe.setTempsCuisson(recetteDTO.getTempsCuisson());
        recipe.setImageUrl(recetteDTO.getImageUrl());
        recipe.setNbrPortion(recetteDTO.getNbrPortion());

        return recipe;
    }

    public Long updateRecipe(RecetteDTO recetteDTO){
        Recette recipe = recetteRepository.findRecetteById(recetteDTO.getId());

        recipe.setNomRecette(recetteDTO.getNomRecette());
        recipe.setCategorie(recetteDTO.getCategorie());
        recipe.setTempsPrep(recetteDTO.getTempsPrep());
        recipe.setTempsCuisson(recetteDTO.getTempsCuisson());
        recipe.setImageUrl(recetteDTO.getImageUrl());
        recipe.setNbrPortion(recetteDTO.getNbrPortion());

        List<Instruction> instructions = instructionRepository.findInstructionByRecette(recipe);
        List<Instruction> instructionsDTO = new ArrayList<>(recetteDTO.getEtapes());
        if(!instructions.isEmpty()){
            if(instructions.size() == instructionsDTO.size()){
                for (int i = 0; i < instructions.size(); i++){
                    Instruction instruction = instructions.get(i);
                    instruction.setDescription(instructionsDTO.get(i).getDescription());

                    instructionRepository.save(instruction);
                }
            } else {
                instructionRepository.deleteAll(instructions);
                for ( Instruction instruction : instructionsDTO){
                    instruction.setRecette(recipe);
                }

                instructionRepository.saveAll(instructionsDTO);
            }
        }else{
            if(!instructionsDTO.isEmpty()){
                for (Instruction instruction : instructionsDTO){
                    instruction.setRecette(recipe);
                    instructionRepository.save(instruction);
                }
            }
        }


        List<TagRecette> tags = tagRecetteRepository.findTagRecetteByRecette(recipe);
        List<Tag> tagsDTO = new ArrayList<>(recetteDTO.getSelectedTags());
        if(!tags.isEmpty()){
            if(tags.size() == tagsDTO.size()){
                for (int i = 0; i < tags.size(); i++){
                    TagRecette tagRecette = tags.get(i);
                    tagRecette.setTag(tagsDTO.get(i));

                    tagRecetteRepository.save(tagRecette);
                }
            } else {
                tagRecetteRepository.deleteAll(tags);
                for (Tag tag : tagsDTO){
                    TagRecette tagRecette = new TagRecette();
                    tagRecette.setRecette(recipe);
                    tagRecette.setTag(tag);

                    tagRecetteRepository.save(tagRecette);
                }
            }
        }else{
            if(!tagsDTO.isEmpty()){
                for (Tag tag : tagsDTO){
                    TagRecette tagRecette = new TagRecette();
                    tagRecette.setTag(tag);
                    tagRecette.setRecette(recipe);

                    tagRecetteRepository.save(tagRecette);
                }
            }
        }

        ingredientRecetteRepository.deleteAll(ingredientRecetteRepository.findIngredientRecetteByRecette(recipe));
        List<IngredientRecetteDTO> ingredients = new ArrayList<>(recetteDTO.getIngredients());
        saveIngredientRecetteDTO(ingredients, recipe);

        return recipe.getId();
    }

    public void deleteRecipeByRecipeId(Long recipeId){
        Recette recipe = recetteRepository.findRecetteById(recipeId);

        if(recipe != null){
            instructionRepository.deleteAll(instructionRepository.findInstructionByRecette(recipe));
            ingredientRecetteRepository.deleteAll(ingredientRecetteRepository.findIngredientRecetteByRecette(recipe));
            tagRecetteRepository.deleteAll(tagRecetteRepository.findTagRecetteByRecette(recipe));

            recetteRepository.delete(recipe);
        }
    }

    public void saveIngredientRecetteDTO(List<IngredientRecetteDTO> ingredients, Recette recipe){
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
    }
}
