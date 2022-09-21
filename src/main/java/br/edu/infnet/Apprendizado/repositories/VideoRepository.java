package br.edu.infnet.Apprendizado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.Apprendizado.entities.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{

}
