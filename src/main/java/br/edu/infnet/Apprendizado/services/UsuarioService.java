package br.edu.infnet.Apprendizado.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Usuario;
import br.edu.infnet.Apprendizado.repositories.UsuarioRepository;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	private static Long id = 1L;
	private static Map<Long, Usuario> mapaIdUsers = new HashMap<>();
	private static Map<String, Usuario> mapaUsers = new HashMap<>();
	
	public Usuario validate(String email, String senha) {
		Usuario user = mapaUsers.get(email);
		if(user != null && user.getSenha().equals(senha)) {
			return user;
		}
		return null;
	}
	
	public void incluir(Usuario usuario) {
		repository.save(usuario);
		usuario.setId(id++);
		mapaIdUsers.put(usuario.getId(), usuario);
		mapaUsers.put(usuario.getEmail(), usuario);
		AppImprimir.relatorio(String.valueOf(usuario.getId()), usuario);
	}
	
	public Collection<Usuario> obterLista(){
		return mapaUsers.values();
	}
	
	public void excluir(String email) {
		repository.deleteByEmail(email);
		mapaUsers.remove(email);
	}
}
