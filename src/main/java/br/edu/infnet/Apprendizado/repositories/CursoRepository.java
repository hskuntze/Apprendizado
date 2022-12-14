package br.edu.infnet.Apprendizado.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.infnet.Apprendizado.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
	@Query("FROM Curso c WHERE c.usuario.id = :userId")
	List<Curso> obterLista(Long userId);
}
