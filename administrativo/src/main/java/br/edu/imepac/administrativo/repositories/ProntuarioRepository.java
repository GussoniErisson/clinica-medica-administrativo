package br.edu.imepac.administrativo.repositories;

import br.edu.imepac.administrativo.entidades.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
}
