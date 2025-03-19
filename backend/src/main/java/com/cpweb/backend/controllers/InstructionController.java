package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.Instruction;
import com.cpweb.backend.models.Recette;
import com.cpweb.backend.repositories.IngredientRepository;
import com.cpweb.backend.repositories.InstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instruction")
@CrossOrigin()
public class InstructionController {

    @Autowired
    InstructionRepository repo;

    @PostMapping("/newInstruction")
    public Instruction createInstruction(@RequestBody Instruction instruction){
        repo.save(instruction);

        return instruction;
    }

    @GetMapping("/getInstructionById")
    @ResponseBody
    public Instruction getInstructionById(long id){
        return repo.findInstructionById(id);
    }
    @GetMapping("/getInstructionByRecette")
    @ResponseBody
    public List<Instruction> getInstructionByRecette(Recette recette){
        return repo.findInstructionByRecette(recette);
    }

    @GetMapping("/getAllInstruction")
    @ResponseBody
    public List<Instruction> getAllInstruction(){
        return repo.findAll();
    }
}
