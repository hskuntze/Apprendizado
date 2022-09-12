package br.edu.infnet.Apprendizado.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Tarefa;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class TarefaService {
	private static Map<Long, Tarefa> tarefasMap = new HashMap<>();
	private static Long id = 1L;
	
	public void incluir(Tarefa tarefa) {
		tarefa.setId(id++);
		tarefasMap.put(tarefa.getId(), tarefa);
		AppImprimir.relatorio(tarefa.getTitulo(), tarefa);
	}
	
	public List<Tarefa> obterLista(){
		return tarefasMap.values().stream().toList();
	}
	
	public void excluir(Long id) {
		tarefasMap.remove(id);
	}
}
