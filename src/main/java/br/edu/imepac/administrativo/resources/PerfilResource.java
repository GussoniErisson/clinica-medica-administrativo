package br.edu.imepac.administrativo.resources;

import br.edu.imepac.administrativo.dtos.Perfil.PerfilCreateDTO;
import br.edu.imepac.administrativo.dtos.Perfil.PerfilDTO;
import br.edu.imepac.administrativo.dtos.Perfil.PerfilUpdateDTO;
import br.edu.imepac.administrativo.service.PerfilService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.Data;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {

    private final PerfilService perfilService;

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerfil(@PathVariable Long id) {
        perfilService.delete(id);
    }

    @Data
    public static class Perfil {
        private String nome;
        private boolean cadastrarFuncionario;
        private boolean lerFuncionario;
        private boolean atualizarFuncionario;
        private boolean deletarFuncionario;
        private boolean listarFuncionario;
        private boolean cadastrarPaciente;
        private boolean lerPaciente;
        private boolean atualizarPaciente;
        private boolean deletarPaciente;
        private boolean listarPaciente;
        private boolean cadastrarFormulario;
        private boolean lerFormulario;
        private boolean atualizarFormulario;
        private boolean deletarFormulario;
        private boolean listarFormulario;
        private boolean cadastrarEspecialidade;
        private boolean lerEspecialidade;
        private boolean atualizarEspecialidade;
        private boolean deletarEspecialidade;
        private boolean listarEspecialidade;
        private boolean cadastrarConvenio;
        private boolean lerConvenio;
        private boolean atualizarConvenio;
        private boolean deletarConvenio;
        private boolean listarConvenio;
    }
}
