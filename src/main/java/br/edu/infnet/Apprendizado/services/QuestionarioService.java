package br.edu.infnet.Apprendizado.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Questionario;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class QuestionarioService {
	private static Map<Long, Questionario> questMap = new HashMap<>();
	private static Long id = 1L;
	
	public void incluir(Questionario questionario) {
		questionario.setId(id++);
		questMap.put(questionario.getId(), questionario);
		AppImprimir.relatorio(questionario.getTitulo(), questionario);
	}
	
	public List<Questionario> obterLista(){
		return questMap.values().stream().toList();
	}
	
	public void excluir(Long id) {
		questMap.remove(id);
	}
}
