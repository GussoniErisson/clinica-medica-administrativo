package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Convenio.ConvenioCreateDTO;
import br.edu.imepac.administrativo.dtos.Convenio.ConvenioDTO;
import br.edu.imepac.administrativo.dtos.Convenio.ConvenioUpdateDTO;
import br.edu.imepac.administrativo.entidades.Convenio;
import br.edu.imepac.administrativo.repositories.ConvenioRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class ConvenioService {

    private final ConvenioRepository convenioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ConvenioService(ConvenioRepository convenioRepository, ModelMapper modelMapper) {
        this.convenioRepository = convenioRepository;
        this.modelMapper = modelMapper;
    }

    public ConvenioDTO salvar(ConvenioCreateDTO convenioCreateDto) {
        Convenio convenio = modelMapper.map(convenioCreateDto, Convenio.class);
        convenio = convenioRepository.save(convenio);
        return modelMapper.map(convenio, ConvenioDTO.class);
    }

    public void remover(Long id) {
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Convênio não encontrado!"));
        convenioRepository.delete(convenio);
        log.info("Convênio deletado com sucesso!");
    }

    public ConvenioDTO atualizar(Long id, ConvenioUpdateDTO convenioUpdateDto) {
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Convênio não encontrado!"));
        modelMapper.map(convenioUpdateDto, convenio);
        convenio = convenioRepository.save(convenio);
        return modelMapper.map(convenio, ConvenioDTO.class);
    }

    public ConvenioDTO buscarPorId(Long id) {
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Convênio não encontrado!"));
        return modelMapper.map(convenio, ConvenioDTO.class);
    }

    public List<ConvenioDTO> listarTodos() {
        List<Convenio> convenios = convenioRepository.findAll();
        return modelMapper.map(convenios, List.class);
    }
}