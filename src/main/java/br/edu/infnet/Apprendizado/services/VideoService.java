package br.edu.infnet.Apprendizado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Video;
import br.edu.infnet.Apprendizado.repositories.VideoRepository;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository repository;
	
	public void incluir(Video video) {
		repository.save(video);
		AppImprimir.relatorio(video.getTitulo(), video);
	}
	
	public List<Video> obterLista(){
		return repository.findAll();
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}
}
