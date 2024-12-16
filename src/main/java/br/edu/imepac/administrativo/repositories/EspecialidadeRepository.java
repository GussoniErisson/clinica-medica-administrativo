package br.edu.imepac.administrativo.repositories;

import br.edu.imepac.administrativo.entidades.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {

}
