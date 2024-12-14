package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Paciente.PacienteCreateDto;
import br.edu.imepac.administrativo.dtos.Paciente.PacienteDto;
import br.edu.imepac.administrativo.entidades.Paciente;
import br.edu.imepac.administrativo.repositories.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    ModelMapper modelMapper;

    public PacienteDto createPaciente(PacienteCreateDto pacienteCreateDto){
        Paciente paciente = modelMapper.map(pacienteCreateDto, Paciente.class);
        Paciente savedPaciente = pacienteRepository.save(paciente);
        return modelMapper.map(savedPaciente, PacienteDto.class);
    }

    public List<PacienteDto> getAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(paciente -> modelMapper.map(paciente, PacienteDto.class)).toList();
    }

    public PacienteDto getPacienteById(Long id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return modelMapper.map(paciente, PacienteDto.class);
    }

    public PacienteDto updatePaciente(Long id, PacienteCreateDto pacienteCreateDto) {
        Paciente pacienteSaved = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado com o id " + id));
        modelMapper.map(pacienteCreateDto, pacienteSaved);
        Paciente updatedPaciente = pacienteRepository.save(pacienteSaved);
        return modelMapper.map(updatedPaciente, PacienteDto.class);
    }


    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

}