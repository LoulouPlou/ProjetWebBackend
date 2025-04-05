package com.cpweb.backend.controllers;

import com.cpweb.backend.models.Instruction;
import com.cpweb.backend.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instruction")
@CrossOrigin()
public class InstructionController {

    @Autowired
    InstructionService instructionService;

    @PostMapping("/newInstruction")
    public void createInstruction(@RequestBody Instruction instruction){
        instructionService.createInstruction(instruction);
    }
}
