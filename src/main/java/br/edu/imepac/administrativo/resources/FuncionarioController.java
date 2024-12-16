package br.edu.imepac.administrativo.resources;


import br.edu.imepac.administrativo.dtos.FuncionarioDTO.FuncionarioCreateDTO;
import br.edu.imepac.administrativo.dtos.FuncionarioDTO.FuncionarioDTO;
import br.edu.imepac.administrativo.dtos.FuncionarioDTO.FuncionarioUpdateDTO;
import br.edu.imepac.administrativo.entidades.Funcionario;
import br.edu.imepac.administrativo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    @ResponseStatus(code = OK)
    public List<Funcionario> listarTodos() {
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

