package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Paciente.PacienteCreateDTO;
import br.edu.imepac.administrativo.dtos.Paciente.PacienteDTO;
import br.edu.imepac.administrativo.dtos.Paciente.PacienteUpdateDTO;
import br.edu.imepac.administrativo.entidades.Paciente;
import br.edu.imepac.administrativo.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    public PacienteDTO save(PacienteCreateDTO pacienteCreateDto) {
        Paciente paciente = modelMapper.map(pacienteCreateDto, Paciente.class);
        paciente = pacienteRepository.save(paciente);
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    public void delete(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado!"));
        pacienteRepository.delete(paciente);
        log.info("Paciente deletado com sucesso!");
    }

    public PacienteDTO update(Long id, PacienteUpdateDTO pacienteUpdateDto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado!"));
        modelMapper.map(pacienteUpdateDto, paciente);
        paciente = pacienteRepository.save(paciente);
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    public PacienteDTO findById(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado!"));
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    public List<PacienteDTO> findAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return modelMapper.map(pacientes, List.class);
    }
}