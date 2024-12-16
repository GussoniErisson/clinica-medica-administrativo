package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeCreateDTO;
import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeDTO;
import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeUptadeDTO;
import br.edu.imepac.administrativo.entidades.Especialidade;
import br.edu.imepac.administrativo.repositories.EspecialidadeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EspecialidadeService(EspecialidadeRepository especialidadeRepository, ModelMapper modelMapper) {
        this.especialidadeRepository = especialidadeRepository;
        this.modelMapper = modelMapper;
    }

    public EspecialidadeDTO salvar(EspecialidadeCreateDTO especialidadeCreateDto) {
        Especialidade especialidade = modelMapper.map(especialidadeCreateDto, Especialidade.class);
        especialidade = especialidadeRepository.save(especialidade);
        return modelMapper.map(especialidade, EspecialidadeDTO.class);
    }

    public void remover(Long id) {
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada!"));
        especialidadeRepository.delete(especialidade);
        log.info("Especialidade deletada com sucesso!");
    }

    public EspecialidadeDTO atualizar(Long id, EspecialidadeUptadeDTO especialidadeUpdateDto) {
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada!"));
        modelMapper.map(especialidadeUpdateDto, especialidade);
        especialidade = especialidadeRepository.save(especialidade);
        return modelMapper.map(especialidade, EspecialidadeDTO.class);
    }

    public EspecialidadeDTO buscarPorId(Long id) {
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada!"));
        return modelMapper.map(especialidade, EspecialidadeDTO.class);
    }

    public List<EspecialidadeDTO> listarTodas() {
        List<Especialidade> especialidades = especialidadeRepository.findAll();
        return modelMapper.map(especialidades, List.class);
    }
}