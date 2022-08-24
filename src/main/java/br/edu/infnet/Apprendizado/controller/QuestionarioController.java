package br.edu.infnet.Apprendizado.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.entities.Questionario;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Controller
@RequestMapping(value = "/questionarios")
public class QuestionarioController {
	
	private static Map<Long, Questionario> questMap = new HashMap<>();
	private static Long id = 1L;
	
	public static void incluir(Questionario questionario) {
		questionario.setId(id++);
		questMap.put(questionario.getId(), questionario);
		AppImprimir.relatorio(questionario.getTitulo(), questionario);
	}
	
	public static List<Questionario> obterLista(){
		return questMap.values().stream().toList();
	}
	
	public static void excluir(Long id) {
		questMap.remove(id);
	}
	
	@GetMapping(value = "/lista")
	public String lista(Model model) {
		model.addAttribute("listagemQuestionarios", obterLista());
		return "questionario/lista";
	}
	
	@GetMapping(value = "/{id}/excluir")
	public String deletar(@PathVariable Long id) {
		excluir(id);
		return "redirect:/questionarios/lista";
	}
}
