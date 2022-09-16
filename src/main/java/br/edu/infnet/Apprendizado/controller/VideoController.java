package br.edu.infnet.Apprendizado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.entities.Video;
import br.edu.infnet.Apprendizado.services.VideoService;

@Controller
@RequestMapping(value = "/videos")
public class VideoController {
	
	@Autowired
	private VideoService service;
	
	@GetMapping(value = "/lista")
	public String lista(Model model) {
		model.addAttribute("listagemVideos", service.obterLista());
		return "video/lista";
	}
	
	@GetMapping(value = "/cadastro")
	public String telaCadastro() {
		return "video/cadastro";
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(Video video) {
		if(video != null) {
			service.incluir(video);
		}
		return "redirect:/videos/lista";
	}
	
	@GetMapping(value = "{id}/excluir")
	public String deletar(@PathVariable Long id) {
		service.excluir(id);
		return "redirect:/videos/lista";
	}
}
