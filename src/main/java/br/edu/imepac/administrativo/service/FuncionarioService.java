package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.dtos.FuncionarioDTO.FuncionarioCreateDTO;
import br.edu.imepac.administrativo.dtos.FuncionarioDTO.FuncionarioDTO;
import br.edu.imepac.administrativo.dtos.FuncionarioDTO.FuncionarioUpdateDTO;
import br.edu.imepac.administrativo.entidades.Funcionario;
import br.edu.imepac.administrativo.repositories.FuncionarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionariorepository;

    private final ModelMapper modelMapper;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionariorepository, ModelMapper modelMapper) {
        this.funcionariorepository = funcionariorepository;
        this.modelMapper = modelMapper;
    }

    public FuncionarioDTO cadastrarFuncionario(FuncionarioCreateDTO funcionarioCreateDTO) {
        Funcionario funcionario = modelMapper.map(funcionarioCreateDTO, Funcionario.class);
        funcionario = funcionariorepository.save(funcionario);
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }


    public void excluirFuncionario(Long id) {
        Funcionario funcionario = funcionariorepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado!"));
        funcionariorepository.delete(funcionario);
        log.info("Funcionario deletado com sucesso!");
    }

    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioUpdateDTO funcionarioUpdateDTO) {
        Funcionario funcionario = funcionariorepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado!"));
        modelMapper.map(funcionarioUpdateDTO, funcionario);
        funcionario = funcionariorepository.save(funcionario);
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

    public FuncionarioDTO listarFuncionario(Long id) {
        Funcionario funcionario = funcionariorepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado!"));
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

    public List<Funcionario> listarFuncionario() {
        return funcionariorepository.findAll();
    }

}





