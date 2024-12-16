package br.edu.imepac.administrativo.resources;

import br.edu.imepac.administrativo.dtos.Perfil.PerfilCreateDTO;
import br.edu.imepac.administrativo.dtos.Perfil.PerfilDTO;
import br.edu.imepac.administrativo.dtos.Perfil.PerfilUpdateDTO;
import br.edu.imepac.administrativo.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {

    private PerfilService perfilService;

    @Autowired
    public PerfilResource(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PerfilDTO savePerfil(@RequestBody PerfilCreateDTO perfilCreateDto) {
        return perfilService.save(perfilCreateDto);
    }

    @GetMapping
    public List<PerfilDTO> listAllPerfis() {
        return perfilService.findAll();
    }

    @GetMapping("/{id}")
    public PerfilDTO getPerfilById(@PathVariable Long id) {
        return perfilService.findById(id);
    }

    @PutMapping("/{id}")
    public PerfilDTO updatePerfil(@PathVariable Long id, @RequestBody PerfilUpdateDTO perfilDetails) {
        return perfilService.update(id, perfilDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerfil(@PathVariable Long id) {
        perfilService.delete(id);
    }
}