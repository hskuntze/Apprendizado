package br.edu.infnet.Apprendizado.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Conteudo;

@Service
public class ConteudoService {
	
	@Autowired
	private QuestionarioService questService;
	@Autowired
	private TarefaService tarefaService;
	@Autowired
	private VideoService videoService;
	
	public List<Conteudo> obterLista(){
		List<Conteudo> lista = new ArrayList<>();
		lista.addAll(questService.obterLista());
		lista.addAll(tarefaService.obterLista());
		lista.addAll(videoService.obterLista());
		return lista;
	}
}
