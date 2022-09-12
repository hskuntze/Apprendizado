package br.edu.infnet.Apprendizado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.entities.Usuario;
import br.edu.infnet.Apprendizado.services.UsuarioService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", service.obterLista());
		return "aluno/lista";
	}
	
	@GetMapping(value = "/cadastro")
	public String telaCadastro() {
		return "aluno/cadastro";
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(Usuario usuario) {
		if(usuario != null) {
			service.incluir(usuario);
		}
		return "redirect:/";
	}
	
	@GetMapping(value = "{email}/excluir")
	public String excluir(@PathVariable String email) {
		service.excluir(email);
		return "redirect:/usuarios/lista";
	}
}
