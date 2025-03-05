package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Categorie;
import com.cpweb.backend.models.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructionRepository extends JpaRepository<Instruction, Integer> {
}
