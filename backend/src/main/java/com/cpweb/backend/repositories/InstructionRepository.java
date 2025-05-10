package com.cpweb.backend.repositories;

import com.cpweb.backend.models.Ingredient;
import com.cpweb.backend.models.Instruction;
import com.cpweb.backend.models.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "instruction", path = "instruction")
public interface InstructionRepository extends JpaRepository<Instruction, Long> {
    public Instruction findInstructionById(long id);

    public List<Instruction> findInstructionByRecetteOrderByNumEtape (Recette recette);

    //public Instruction findInstructionByRecette (long id);


}
