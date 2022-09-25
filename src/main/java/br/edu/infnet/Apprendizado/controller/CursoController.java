package br.edu.infnet.Apprendizado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.Apprendizado.entities.Curso;
import br.edu.infnet.Apprendizado.entities.Usuario;
import br.edu.infnet.Apprendizado.services.ConteudoService;
import br.edu.infnet.Apprendizado.services.CursoService;
import br.edu.infnet.Apprendizado.services.ResponsavelService;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@Autowired
	private ResponsavelService respService;
	
	@Autowired
	private ConteudoService contService;
	
	@GetMapping(value = "/lista")
	public String lista(Model model, @SessionAttribute("user") Usuario u) {
		model.addAttribute("listagemCursos", service.obterLista(u));
		return "curso/lista";
	}
	
	@GetMapping(value = "/cadastro")
	public String telaCadastro(Model model) {
		model.addAttribute("responsaveis", respService.obterLista());
		model.addAttribute("conteudos", contService.obterLista());
		return "curso/cadastro";
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(Curso curso, @SessionAttribute("user") Usuario u) {
		if(curso != null) {
			curso.setUsuario(u);
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
