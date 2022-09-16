package br.edu.infnet.Apprendizado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.entities.Tarefa;
import br.edu.infnet.Apprendizado.services.TarefaService;

@Controller
@RequestMapping(value = "/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaService service;
	
	@GetMapping(value = "/lista")
	public String lista(Model model) {
		model.addAttribute("listagemTarefas", service.obterLista());
		return "tarefa/lista";
	}
	
	@GetMapping(value = "/cadastro")
	public String telaCadastro() {
		return "tarefa/cadastro";
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(Tarefa tarefa) {
		if(tarefa != null) {
			service.incluir(tarefa);
		}
		return "redirect:/tarefas/lista";
	}
	
	@GetMapping(value = "/{id}/excluir")
	public String deletar(@PathVariable Long id) {
		service.excluir(id);
		return "redirect:/tarefas/lista";
	}
}
