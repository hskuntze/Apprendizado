package br.edu.infnet.Apprendizado.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.infnet.Apprendizado.entities.Conteudo;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long>{
	
	@Query("FROM Conteudo c WHERE c.usuario.id = :userId")
	List<Conteudo> obterLista(Long userId);
}
