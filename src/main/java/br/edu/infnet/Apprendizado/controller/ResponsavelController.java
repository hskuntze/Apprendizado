package br.edu.infnet.Apprendizado.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.Apprendizado.entities.Responsavel;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Controller
@RequestMapping(value = "/responsaveis")
public class ResponsavelController {
	private static Map<Long, Responsavel> respMap = new HashMap<>();
	private static Long id = 1L;
	
	public static void incluir(Responsavel responsavel) {
		responsavel.setId(id++);
		respMap.put(responsavel.getId(), responsavel);
		AppImprimir.relatorio(responsavel.getNome(), responsavel);
	}
	
	public static List<Responsavel> obterLista(){
		return respMap.values().stream().toList();
	}
	
	public static void excluir(Long id) {
		respMap.remove(id);
	}
	
	@GetMapping(value = "/lista")
	public String lista(Model model) {
		model.addAttribute("listagemResps", obterLista());
		return "responsavel/lista";
	}
	
	@GetMapping(value = "{id}/excluir")
	public String deletar(@PathVariable Long id) {
		excluir(id);
		return "redirect:/responsaveis/lista";
	}
}
