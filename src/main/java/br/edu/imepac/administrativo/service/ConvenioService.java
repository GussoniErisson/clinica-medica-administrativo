package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Convenio.ConvenioDto;
import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeDto;
import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeCreateDto;
import br.edu.imepac.administrativo.entidades.Convenio;
import br.edu.imepac.administrativo.entidades.Especialidade;
import br.edu.imepac.administrativo.repositories.ConvenioRepository;
import br.edu.imepac.administrativo.repositories.EspecialidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ConvenioDto> listarTodas() {
        return convenioRepository.findAll()
                .stream()
                .map(convenio -> modelMapper.map(convenio, ConvenioDto.class))
                .collect(Collectors.toList());
    }

    public Optional<ConvenioDto> buscarPorId(Long id) {
        List<Convenio> convenio = convenioRepository.findById(id);
        return convenio.map(e -> modelMapper.map(e, ConvenioDto.class));
    }

    public ConvenioDto salvarOuAtualizar(ConvenioDto convenioDto) {
        Convenio convenio = modelMapper.map(convenioDto, Convenio.class);
        Convenio salvo = convenioRepository.save(convenio);
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