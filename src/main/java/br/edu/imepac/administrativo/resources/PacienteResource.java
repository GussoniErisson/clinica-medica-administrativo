package br.edu.imepac.administrativo.resources;

import br.edu.imepac.administrativo.dtos.Paciente.PacienteCreateDto;
import br.edu.imepac.administrativo.dtos.Paciente.PacienteDto;
import br.edu.imepac.administrativo.service.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("api/paciente")
public class PacienteResource {

    private static final Logger logger = LoggerFactory.getLogger(PacienteResource.class);

    @Autowired
    public PacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteDto createPaciente(@RequestBody PacienteCreateDto pacienteCreateDto){
        return pacienteService.createPaciente(pacienteCreateDto);
    }

    @GetMapping
    public List<PacienteDto> getAllPacientes(){
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDto getPacienteById(@PathVariable Long id){
        PacienteDto paciente = pacienteService.getPacienteById(id);
        if (paciente == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado com o id " + id);
        } else {
            return paciente;
        }
    }

    @PutMapping("/{id}")
    public PacienteDto updatePaciente(@PathVariable Long id, @RequestBody PacienteCreateDto pacienteCreateDto){
        return pacienteService.updatePaciente(id, pacienteCreateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long id){
        pacienteService.deletePaciente(id);
    }
}