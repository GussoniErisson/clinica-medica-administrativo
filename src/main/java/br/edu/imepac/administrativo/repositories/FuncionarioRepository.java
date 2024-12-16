package br.edu.imepac.administrativo.repositories;

import br.edu.imepac.administrativo.entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
