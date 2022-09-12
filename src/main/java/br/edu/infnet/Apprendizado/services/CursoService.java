package br.edu.infnet.Apprendizado.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Curso;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class CursoService {
	private static Map<Long, Curso> cursoMap = new HashMap<>();
	private static Long id = 1L;
	
	public void incluir(Curso curso) {
		curso.setId(id++);
		cursoMap.put(curso.getId(), curso);
		AppImprimir.relatorio(curso.getTitulo(), curso);
	}
	
	public List<Curso> obterLista(){
		return cursoMap.values().stream().toList();
	}
	
	public void excluir(Long id) {
		cursoMap.remove(id);
	}
}
