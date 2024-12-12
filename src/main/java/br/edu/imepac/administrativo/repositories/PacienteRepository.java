package br.edu.imepac.administrativo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.imepac.administrativo.entidades.Paciente;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
