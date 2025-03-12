package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Instruction;
import com.cpweb.backend.repositories.InstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
