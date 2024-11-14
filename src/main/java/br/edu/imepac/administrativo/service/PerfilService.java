package br.edu.imepac.administrativo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.imepac.administrativo.repositories.PerfilRepository;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository PerfilRepository;
}
