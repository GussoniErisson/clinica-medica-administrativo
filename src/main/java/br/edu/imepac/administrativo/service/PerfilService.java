package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Perfil.PerfilCreateDTO;
import br.edu.imepac.administrativo.dtos.Perfil.PerfilDTO;
import br.edu.imepac.administrativo.dtos.Perfil.PerfilUpdateDTO;
import br.edu.imepac.administrativo.entidades.Perfil;
import br.edu.imepac.administrativo.repositories.PerfilRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PerfilService(PerfilRepository perfilRepository, ModelMapper modelMapper) {
        this.perfilRepository = perfilRepository;
        this.modelMapper = modelMapper;
    }

    public PerfilDTO save(PerfilCreateDTO perfilCreateDTO) {
        Perfil perfil = modelMapper.map(perfilCreateDTO, Perfil.class);
        perfil = perfilRepository.save(perfil);
        return modelMapper.map(perfil, PerfilDTO.class);
    }

    public void delete(Long id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado!"));
        perfilRepository.delete(perfil);
        log.info("Perfil deletado com sucesso!");
    }

    public List<PerfilDTO> findAll() {
        List<Perfil> perfis = perfilRepository.findAll();
        return modelMapper.map(perfis, List.class);
    }

    public PerfilDTO update(Long id, PerfilUpdateDTO perfilUpdateDTO) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado!"));
        modelMapper.map(perfilUpdateDTO, perfil);
        perfil = perfilRepository.save(perfil);
        return modelMapper.map(perfil, PerfilDTO.class);
    }

    public PerfilDTO findById(Long id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado!"));
        return modelMapper.map(perfil, PerfilDTO.class);
    }
}