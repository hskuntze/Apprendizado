package br.edu.infnet.Apprendizado.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Curso;
import br.edu.infnet.Apprendizado.repositories.CursoRepository;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
//	private static Map<Long, Curso> cursoMap = new HashMap<>();
//	private static Long id = 1L;
	
	public void incluir(Curso curso) {
//		curso.setId(id++);
		curso.setInicio(Instant.now());
		curso.setFim(curso.getInicio().plus(30, ChronoUnit.DAYS));
//		cursoMap.put(curso.getId(), curso);
		repository.save(curso);
		AppImprimir.relatorio(curso.getTitulo(), curso);
	}
	
	public List<Curso> obterLista(){
//		return cursoMap.values().stream().toList();
		return repository.findAll();
	}
	
	public void excluir(Long id) {
//		cursoMap.remove(id);
		repository.deleteById(id);
	}
}
