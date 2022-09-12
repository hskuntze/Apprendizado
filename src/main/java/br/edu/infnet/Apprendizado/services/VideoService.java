package br.edu.infnet.Apprendizado.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Video;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class VideoService {
	private static Map<Long, Video> videosMap = new HashMap<>();
	private static Long id = 1L;
	
	public void incluir(Video video) {
		video.setId(id++);
		videosMap.put(video.getId(), video);
		AppImprimir.relatorio(video.getTitulo(), video);
	}
	
	public List<Video> obterLista(){
		return videosMap.values().stream().toList();
	}
	
	public void excluir(Long id) {
		videosMap.remove(id);
	}
}
