package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.entidades.Funcionario;
import br.edu.imepac.administrativo.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionariorepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionariorepository) {
        this.funcionariorepository = funcionariorepository;
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        return funcionariorepository.save(funcionario);
    }

    public boolean excluirFuncionario(long id) {
        funcionariorepository.deleteById(id);
        System.out.println("Funcionario deletado com sucesso!");
        return true;
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        if (!funcionariorepository.existsById(id)) {
            throw new RuntimeException("Funcionario não encontrado!");
        }
        funcionario.setId(id);
        return funcionariorepository.save(funcionario);
    }

    public Funcionario listarFuncionario(Long id) {
        return funcionariorepository.findById(id).get();
    }

    public List<Funcionario> listarFuncionario() {
        return funcionariorepository.findAll();
    }

}





