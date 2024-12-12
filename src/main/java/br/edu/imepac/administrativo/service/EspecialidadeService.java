package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeDto;
import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeCreateDto;
import br.edu.imepac.administrativo.entidades.Especialidade;
import br.edu.imepac.administrativo.repositories.EspecialidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<EspecialidadeDto> listarTodas() {
        return especialidadeRepository.findAll()
                .stream()
                .map(especialidade -> modelMapper.map(especialidade, EspecialidadeDto.class))
                .collect(Collectors.toList());
    }

    public Optional<EspecialidadeDto> buscarPorId(Long id) {
        Optional<Especialidade> especialidade = especialidadeRepository.findById(id);
        return especialidade.map(e -> modelMapper.map(e, EspecialidadeDto.class));
    }

    public EspecialidadeDto salvarOuAtualizar(EspecialidadeDto especialidadeDTO) {
        Especialidade especialidade = modelMapper.map(especialidadeDTO, Especialidade.class);
        Especialidade salvo = especialidadeRepository.save(especialidade);
        return modelMapper.map(salvo, EspecialidadeDto.class);
    }

    public void removerPorId(Long id) {
        if (especialidadeRepository.existsById(id)) {
            especialidadeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Especialidade com ID " + id + " não encontrada.");
        }
    }

}