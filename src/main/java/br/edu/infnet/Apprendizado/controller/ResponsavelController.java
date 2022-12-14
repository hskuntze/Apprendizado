package br.edu.infnet.Apprendizado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.Apprendizado.entities.Responsavel;
import br.edu.infnet.Apprendizado.entities.Usuario;
import br.edu.infnet.Apprendizado.services.ResponsavelService;

@Controller
@RequestMapping(value = "/responsaveis")
public class ResponsavelController {
	
	@Autowired
	private ResponsavelService service;
	
	@GetMapping(value = "/lista")
	public String lista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("listagemResps", service.obterLista(usuario));
		return "responsavel/lista";
	}
	
	@GetMapping(value = "/cadastro")
	public String telaCadastro() {
		return "responsavel/cadastro";
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(Responsavel resp, @SessionAttribute("user") Usuario usuario) {
		if(resp != null) {
			resp.setUsuario(usuario);
			service.incluir(resp);
		}
		return "redirect:/responsaveis/lista";
	}
	
	@GetMapping(value = "{id}/excluir")
	public String deletar(@PathVariable Long id) {
		service.excluir(id);
		return "redirect:/responsaveis/lista";
	}
}
