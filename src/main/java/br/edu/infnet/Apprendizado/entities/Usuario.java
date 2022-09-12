package br.edu.infnet.Apprendizado.entities;

import java.util.Objects;

import br.edu.infnet.Apprendizado.exceptions.UsuarioInvalidoException;
import br.edu.infnet.Apprendizado.interfaces.IPrinter;

public class Usuario implements IPrinter{
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario() {
	}

	public Usuario(String nome, String email, String senha) throws UsuarioInvalidoException{
		if((nome == null || nome.isBlank()) || (email == null || email.isBlank()) || (senha == null || senha.isBlank())) {
			throw new UsuarioInvalidoException("Não é possível registrar um responsável com nome, senha e/ou email vazios.");
		}
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public void imprimir() {
		System.out.println("#Usuário");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Usuário id=" + id + "; " + nome + "; " + email + "; " + senha;
	}

}
