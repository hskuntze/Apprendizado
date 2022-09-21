package br.edu.infnet.Apprendizado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.Apprendizado.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
