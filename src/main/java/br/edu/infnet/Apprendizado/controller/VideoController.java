package br.edu.infnet.Apprendizado.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.entities.Video;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Controller
@RequestMapping(value = "/videos")
public class VideoController {
	private static Map<Long, Video> videosMap = new HashMap<>();
	private static Long id = 1L;
	
	public static void incluir(Video video) {
		video.setId(id++);
		videosMap.put(video.getId(), video);
		AppImprimir.relatorio(video.getTitulo(), video);
	}
	
	public static List<Video> obterLista(){
		return videosMap.values().stream().toList();
	}
	
	public static void excluir(Long id) {
		videosMap.remove(id);
	}
	
	@GetMapping(value = "/lista")
	public String lista(Model model) {
		model.addAttribute("listagemVideos", obterLista());
		return "video/lista";
	}
	
	@GetMapping(value = "{id}/excluir")
	public String deletar(@PathVariable Long id) {
		excluir(id);
		return "redirect:/videos/lista";
	}
}
