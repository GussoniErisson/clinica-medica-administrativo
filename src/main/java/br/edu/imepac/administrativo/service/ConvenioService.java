package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Convenio.ConvenioCreateDto;
import br.edu.imepac.administrativo.dtos.Convenio.ConvenioDto;
import br.edu.imepac.administrativo.entidades.Convenio;
import br.edu.imepac.administrativo.repositories.ConvenioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Listar todos os convênios
    public List<ConvenioDto> listarTodos() {
        return convenioRepository.findAll().stream()
                .map(convenio -> modelMapper.map(convenio, ConvenioDto.class))
                .collect(Collectors.toList());
    }

    // Buscar convênio por ID
    public ConvenioDto buscarPorId(Long id) {
        Optional<Convenio> convenio = convenioRepository.findById(id);
        return convenio.map(c -> modelMapper.map(c, ConvenioDto.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Convênio não encontrado com o ID " + id));
    }

    // Salvar um novo convênio
    public ConvenioDto salvar(ConvenioCreateDto convenioCreateDto) {
        Convenio convenio = modelMapper.map(convenioCreateDto, Convenio.class);
        Convenio salvo = convenioRepository.save(convenio);
        return modelMapper.map(salvo, ConvenioDto.class);
    }

    // Atualizar um convênio existente
    public ConvenioDto atualizar(Long id, ConvenioCreateDto convenioCreateDto) {
        Convenio convenioExistente = convenioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Convênio não encontrado com o ID " + id));

        modelMapper.map(convenioCreateDto, convenioExistente);
        Convenio atualizado = convenioRepository.save(convenioExistente);
        return modelMapper.map(atualizado, ConvenioDto.class);
    }

    // Remover um convênio por ID
    public void remover(Long id) {
        if (!convenioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Convênio não encontrado com o ID " + id);
        }
        convenioRepository.deleteById(id);
    }
}