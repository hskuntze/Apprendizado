package br.edu.infnet.Apprendizado.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.entities.Tarefa;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Controller
@RequestMapping(value = "/tarefas")
public class TarefaController {
	private static Map<Long, Tarefa> tarefasMap = new HashMap<>();
	private static Long id = 1L;
	
	public static void incluir(Tarefa tarefa) {
		tarefa.setId(id++);
		tarefasMap.put(tarefa.getId(), tarefa);
		AppImprimir.relatorio(tarefa.getTitulo(), tarefa);
	}
	
	public static List<Tarefa> obterLista(){
		return tarefasMap.values().stream().toList();
	}
	
	public static void excluir(Long id) {
		tarefasMap.remove(id);
	}
	
	@GetMapping(value = "/lista")
	public String lista(Model model) {
		model.addAttribute("listagemTarefas", obterLista());
		return "tarefa/lista";
	}
	
	@GetMapping(value = "/{id}/excluir")
	public String deletar(@PathVariable Long id) {
		excluir(id);
		return "redirect:/tarefas/lista";
	}
}
