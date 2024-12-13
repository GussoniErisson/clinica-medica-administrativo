package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Paciente.PacienteCreateDto;
import br.edu.imepac.administrativo.dtos.Paciente.PacienteDto;
import br.edu.imepac.administrativo.entidades.Paciente;
import br.edu.imepac.administrativo.repositories.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<PacienteDto> findAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(paciente -> modelMapper.map(paciente, PacienteDto.class))
                .collect(Collectors.toList());
    }

    public PacienteDto update(Long id, PacienteDto pacienteDetails) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById();

        if (optionalPaciente.isPresent()) {
            Paciente paciente = optionalPaciente.get();
            paciente.setNome(pacienteDetails.getNome());
            paciente.setBairro(pacienteDetails.getBairro());
            paciente.setCidade(pacienteDetails.getCidade());
            paciente.setComplemento(pacienteDetails.getComplemento());
            paciente.setContato(pacienteDetails.getContato());
            paciente.setCpf(pacienteDetails.getCpf());
            paciente.setDataNascimento(pacienteDetails.getDataNascimento());
            paciente.setIdade(pacienteDetails.getIdade());
            paciente.setSexo(pacienteDetails.getSexo());
            paciente.setRua(pacienteDetails.getRua());
            paciente.setNumero(pacienteDetails.getNumero());
            paciente.setEstado(pacienteDetails.getEstado());
            paciente.setEmail(pacienteDetails.getEmail());

            Paciente updatedPaciente = pacienteRepository.save(paciente);
            return modelMapper.map(updatedPaciente, PacienteDto.class);
        } else {
            return null;
        }
    }

    public PacienteDto save(PacienteCreateDto pacienteCreateDto) {
        Paciente paciente = modelMapper.map(pacienteCreateDto, Paciente.class);
        Paciente savedPaciente = pacienteRepository.save(paciente);
        return modelMapper.map(savedPaciente, PacienteDto.class);
    }

    public PacienteDto findById(Long id) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        return optionalPaciente.map(paciente -> modelMapper.map(paciente, PacienteDto.class)).orElse(null);
    }
}
