package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.Perfil.PerfilCreateDto;
import br.edu.imepac.administrativo.dtos.Perfil.PerfilDto;
import br.edu.imepac.administrativo.entidades.Perfil;
import br.edu.imepac.administrativo.exceptions.PerfilException;
import br.edu.imepac.administrativo.repositories.PerfilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PerfilService {

    private PerfilRepository perfilRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PerfilService(PerfilRepository perfilRepository, ModelMapper modelMapper) {
        this.perfilRepository = perfilRepository;
        this.modelMapper = modelMapper;
    }

    public void delete(Long id) {
        perfilRepository.deleteById(id);
    }

    public List<PerfilDto> findAll() {
        List<Perfil> perfil = perfilRepository.findAll();
        return perfil.stream()
                .map(usuario -> modelMapper.map(usuario, PerfilDto.class))
                .collect(Collectors.toList());
    }

    public PerfilDto update(Long id, PerfilDto perfilDetails) {
        Optional<Perfil> optionalPerfil = perfilRepository.findById(id);

        if (optionalPerfil.isPresent()) {
            Perfil perfil = optionalPerfil.get();
            perfil.setNome(perfilDetails.getNome());
            Perfil updatedPerfil = perfilRepository.save(perfil);
            return modelMapper.map(updatedPerfil, PerfilDto.class);
        } else {
            return null;
        }
    }

    public PerfilCreateDto getPerfilById(Long id) {

        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new PerfilException("Perfil não encontrado com id: " + id));
        return modelMapper.map(perfil, PerfilCreateDto.class);
    }

    public PerfilDto save(PerfilCreateDto perfilRequest) {
        Perfil perfil = modelMapper.map(perfilRequest, Perfil.class);
        Perfil savedUsuario = perfilRepository.save(perfil);
        return modelMapper.map(savedUsuario, PerfilDto.class);
    }

    public PerfilDto findById(Long id) {
        Optional<Perfil> optionalPerfil = perfilRepository.findById(id);
        return optionalPerfil.map(usuario -> modelMapper.map(usuario, PerfilDto.class)).orElse(null);
    }

}