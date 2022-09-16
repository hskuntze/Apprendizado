package br.edu.infnet.Apprendizado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.entities.Questionario;
import br.edu.infnet.Apprendizado.services.QuestionarioService;

@Controller
@RequestMapping(value = "/questionarios")
public class QuestionarioController {
	
	@Autowired
	private QuestionarioService service;
	
	@GetMapping(value = "/lista")
	public String lista(Model model) {
		model.addAttribute("listagemQuestionarios", service.obterLista());
		return "questionario/lista";
	}
	
	@GetMapping(value = "/cadastro")
	public String telaCadastro() {
		return "questionario/cadastro";
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(Questionario questionario) {
		if(questionario != null) {
			service.incluir(questionario);
		}
		return "redirect:/questionarios/lista";
	}
	
	@GetMapping(value = "/{id}/excluir")
	public String deletar(@PathVariable Long id) {
		service.excluir(id);
		return "redirect:/questionarios/lista";
	}
}
