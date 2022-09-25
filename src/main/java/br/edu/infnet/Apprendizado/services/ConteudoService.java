package br.edu.infnet.Apprendizado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Conteudo;
import br.edu.infnet.Apprendizado.entities.Usuario;
import br.edu.infnet.Apprendizado.repositories.ConteudoRepository;

@Service
public class ConteudoService {
	
	@Autowired
	private ConteudoRepository repository;
	
	public List<Conteudo> obterLista(){
		return repository.findAll();
	}
	
	public List<Conteudo> obterLista(Usuario usuario){
		return repository.obterLista(usuario.getId());
	}

	public void excluir(Long id) {
		repository.deleteById(id);
	}
}
