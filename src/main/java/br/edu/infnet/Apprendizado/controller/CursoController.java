package br.edu.infnet.Apprendizado.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.entities.Curso;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController {
	private static Map<Long, Curso> cursoMap = new HashMap<>();
	private static Long id = 1L;
	
	public static void incluir(Curso curso) {
		curso.setId(id++);
		cursoMap.put(curso.getId(), curso);
		AppImprimir.relatorio(curso.getTitulo(), curso);
	}
	
	public static List<Curso> obterLista(){
		return cursoMap.values().stream().toList();
	}
	
	public static void excluir(Long id) {
		cursoMap.remove(id);
	}
	
	@GetMapping(value = "/lista")
	public String lista(Model model) {
		model.addAttribute("listagemCursos", obterLista());
		return "curso/lista";
	}
	
	@GetMapping(value = "{id}/excluir")
	public String deletar(@PathVariable Long id) {
		excluir(id);
		return "redirect:/cursos/lista";
	}
}
