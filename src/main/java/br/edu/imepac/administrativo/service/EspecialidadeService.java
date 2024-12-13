package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeDto;
import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeCreateDto;
import br.edu.imepac.administrativo.entidades.Especialidade;
import br.edu.imepac.administrativo.repositories.EspecialidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Listar todas as especialidades
    public List<EspecialidadeDto> listarTodas() {
        return especialidadeRepository.findAll().stream()
                .map(especialidade -> modelMapper.map(especialidade, EspecialidadeDto.class))
                .collect(Collectors.toList());
    }

    // Buscar especialidade por ID
    public EspecialidadeDto buscarPorId(Long id) {
        Optional<Especialidade> especialidade = especialidadeRepository.findById(id);
        return especialidade.map(e -> modelMapper.map(e, EspecialidadeDto.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada com o ID " + id));
    }

    // Salvar uma nova especialidade
    public EspecialidadeDto salvar(EspecialidadeCreateDto especialidadeCreateDto) {
        Especialidade especialidade = modelMapper.map(especialidadeCreateDto, Especialidade.class);
        Especialidade salvo = especialidadeRepository.save(especialidade);
        return modelMapper.map(salvo, EspecialidadeDto.class);
    }

    // Atualizar uma especialidade existente
    public EspecialidadeDto atualizar(Long id, EspecialidadeCreateDto especialidadeCreateDto) {
        Especialidade especialidadeExistente = especialidadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada com o ID " + id));

        modelMapper.map(especialidadeCreateDto, especialidadeExistente);
        Especialidade atualizado = especialidadeRepository.save(especialidadeExistente);
        return modelMapper.map(atualizado, EspecialidadeDto.class);
    }

    // Remover uma especialidade por ID
    public void remover(Long id) {
        if (!especialidadeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada com o ID " + id);
        }
        especialidadeRepository.deleteById(id);
    }
}