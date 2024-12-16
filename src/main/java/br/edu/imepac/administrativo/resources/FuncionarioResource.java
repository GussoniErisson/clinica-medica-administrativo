package br.edu.imepac.administrativo.resources;


import br.edu.imepac.administrativo.dtos.Funcionario.FuncionarioCreateDTO;
import br.edu.imepac.administrativo.dtos.Funcionario.FuncionarioDTO;
import br.edu.imepac.administrativo.dtos.Funcionario.FuncionarioUpdateDTO;
import br.edu.imepac.administrativo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioResource {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioResource(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    @ResponseStatus(code = OK)
    public List<FuncionarioDTO> listarTodos() {
        return funcionarioService.listarFuncionario();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = OK)
    public FuncionarioDTO buscarPorId(@PathVariable Long id) {
        return funcionarioService.listarFuncionario(id);
    }

    @PostMapping
    @ResponseStatus(code = CREATED)
    public FuncionarioDTO criar(@RequestBody FuncionarioCreateDTO funcionarioCreateDTO) {
        return funcionarioService.cadastrarFuncionario(funcionarioCreateDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = OK)
    public FuncionarioDTO atualizar(@PathVariable Long id, @RequestBody FuncionarioUpdateDTO funcionarioUpdateDTO) {
        return funcionarioService.atualizarFuncionario(id, funcionarioUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        funcionarioService.excluirFuncionario(id);
    }
}

