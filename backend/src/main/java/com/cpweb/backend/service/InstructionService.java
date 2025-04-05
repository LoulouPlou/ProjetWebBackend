package com.cpweb.backend.service;

import com.cpweb.backend.models.Instruction;
import com.cpweb.backend.repositories.InstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructionService {

    private final InstructionRepository instructionRepository;

    public InstructionService(InstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    public void createInstruction(Instruction instruction) {
        instructionRepository.save(instruction);
    }
}
