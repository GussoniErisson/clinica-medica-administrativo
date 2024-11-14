package br.edu.imepac.administrativo.service;

import br.edu.imepac.administrativo.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private final FuncionarioRepository productRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionariorepository) {
        this.productRepository = productRepository;
    }
}
