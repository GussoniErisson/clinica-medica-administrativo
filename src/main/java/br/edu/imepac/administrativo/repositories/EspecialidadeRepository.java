package br.edu.imepac.administrativo.repositories;

import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeDto;
import br.edu.imepac.administrativo.entidades.Especialidade;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    List<EspecialidadeDto> findByNomeContainingIgnoreCase(String nome);

}
