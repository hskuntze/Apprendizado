package br.edu.infnet.Apprendizado.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Curso;
import br.edu.infnet.Apprendizado.entities.Usuario;
import br.edu.infnet.Apprendizado.repositories.CursoRepository;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	public void incluir(Curso curso) {
		curso.setInicio(Instant.now());
		curso.setFim(curso.getInicio().plus(30, ChronoUnit.DAYS));
		repository.save(curso);
		AppImprimir.relatorio(curso.getTitulo(), curso);
	}
	
	public List<Curso> obterLista(){
		return repository.findAll();
	}
	
	public List<Curso> obterLista(Usuario usuario){
		return repository.obterLista(usuario.getId());
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}
}
