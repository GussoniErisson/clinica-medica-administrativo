package br.edu.imepac.administrativo.resources;

import br.edu.imepac.administrativo.controller.dtos.Paciente.PacienteCreateDto;
import br.edu.imepac.administrativo.controller.dtos.Paciente.PacienteDto;
import br.edu.imepac.administrativo.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteResource {

    private static final Logger logger = LoggerFactory.getLogger(PacienteResource.class);
    private final PacienteService pacienteService;

    @Autowired
    public PacienteResource(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }



    @GetMapping
    @Operation(summary = "Listar todos os pacientes", description = "Retorna uma lista de todos os pacientes cadastrados.")
    public ResponseEntity<List<PacienteDto>> findAll() {
        logger.info("Fetching all patients");
        List<PacienteDto> pacientes = pacienteService.findAll();
        logger.info("Found {} patients", pacientes.size());
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar paciente por ID", description = "Retorna os detalhes de um paciente específico pelo ID.")
    public ResponseEntity<PacienteDto> findById(@PathVariable Long id) {
        logger.info("Fetching patient with id: {}", id);
        PacienteDto paciente = pacienteService.findById(id);
        if (paciente != null) {
            logger.info("Patient found: {}", paciente);
            return ResponseEntity.ok(paciente);
        } else {
            logger.warn("Patient with id: {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    @Operation(summary = "Criar um novo paciente", description = "Adiciona um novo paciente ao sistema.")
    public ResponseEntity<PacienteDto> create(@RequestBody PacienteCreateDto pacienteCreateDto) {
        logger.info("Creating new patient with data: {}", pacienteCreateDto);
        PacienteDto createdPaciente = pacienteService.save(pacienteCreateDto);
        logger.info("Patient created with id: {}", createdPaciente.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPaciente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um paciente", description = "Atualiza as informações de um paciente existente pelo ID.")
    public ResponseEntity<PacienteDto> update(@PathVariable Long id, @RequestBody PacienteDto pacienteDetails) {
        logger.info("Updating patient with id: {}", id);
        PacienteDto updatedPaciente = pacienteService.update(id, pacienteDetails);
        if (updatedPaciente != null) {
            logger.info("Patient updated: {}", updatedPaciente);
            return ResponseEntity.ok(updatedPaciente);
        } else {
            logger.warn("Patient with id: {} not found for update", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um paciente", description = "Remove um paciente do sistema pelo ID.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting patient with id: {}", id);
        pacienteService.delete(id);
        logger.info("Patient with id: {} deleted", id);
        return ResponseEntity.noContent().build();
    }
}

