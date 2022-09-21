package br.edu.infnet.Apprendizado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Responsavel;
import br.edu.infnet.Apprendizado.entities.Usuario;
import br.edu.infnet.Apprendizado.repositories.ResponsavelRepository;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class ResponsavelService {
	
	@Autowired
	private ResponsavelRepository repository;
	
	public void incluir(Responsavel responsavel) {
		repository.save(responsavel);
		AppImprimir.relatorio(responsavel.getNome(), responsavel);
	}
	
	public List<Responsavel> obterLista(){
		return repository.findAll();
	}
	
	public List<Responsavel> obterLista(Usuario usuario){
		return repository.obterLista(usuario.getId());
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}
}
