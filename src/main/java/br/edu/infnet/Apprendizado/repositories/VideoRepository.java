package br.edu.infnet.Apprendizado.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.infnet.Apprendizado.entities.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{
	
	@Query("FROM Video v WHERE v.usuario.id = :userId")
	List<Video> obterLista(Long userId);
}
