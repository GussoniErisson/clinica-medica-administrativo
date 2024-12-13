package br.edu.imepac.administrativo.repositories;

import br.edu.imepac.administrativo.entidades.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConvenioRepository extends  JpaRepository<Convenio, Long> {
    List<Convenio> findById(Long id);

}
