package br.edu.infnet.Apprendizado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.entities.Curso;
import br.edu.infnet.Apprendizado.services.CursoService;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@GetMapping(value = "/lista")
	public String lista(Model model) {
		model.addAttribute("listagemCursos", service.obterLista());
		return "curso/lista";
	}
	
	@GetMapping(value = "/cadastro")
	public String telaCadastro() {
		return "curso/cadastro";
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(Curso curso) {
		if(curso != null) {
			service.incluir(curso);
		}
		return "redirect:/cursos/lista";
	}
	
	@GetMapping(value = "{id}/excluir")
	public String deletar(@PathVariable Long id) {
		service.excluir(id);
		return "redirect:/cursos/lista";
	}
}
