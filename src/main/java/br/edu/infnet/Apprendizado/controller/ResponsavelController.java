package br.edu.infnet.Apprendizado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.services.ResponsavelService;

@Controller
@RequestMapping(value = "/responsaveis")
public class ResponsavelController {
	
	@Autowired
	private ResponsavelService service;
	
	@GetMapping(value = "/lista")
	public String lista(Model model) {
		model.addAttribute("listagemResps", service.obterLista());
		return "responsavel/lista";
	}
	
	@GetMapping(value = "{id}/excluir")
	public String deletar(@PathVariable Long id) {
		service.excluir(id);
		return "redirect:/responsaveis/lista";
	}
}
