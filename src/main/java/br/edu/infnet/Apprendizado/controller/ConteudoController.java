package br.edu.infnet.Apprendizado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.Apprendizado.entities.Usuario;
import br.edu.infnet.Apprendizado.services.ConteudoService;

@Controller
@RequestMapping(value = "/conteudos")
public class ConteudoController {
	
	@Autowired
	private ConteudoService service;
	
	@GetMapping(value = "/lista")
	public String lista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("listagemConteudos", service.obterLista());
		return "conteudo/lista";
	}
	
	@GetMapping(value = "{id}/excluir")
	public String deletar(@PathVariable Long id) {
		service.excluir(id);
		return "redirect:/conteudo/lista";
	}
}
