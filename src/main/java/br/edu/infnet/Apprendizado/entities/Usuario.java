package br.edu.infnet.Apprendizado.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.infnet.Apprendizado.exceptions.UsuarioInvalidoException;
import br.edu.infnet.Apprendizado.interfaces.IPrinter;

@Entity
@Table(name = "tb_user")
public class Usuario implements IPrinter, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Responsavel> responsaveis = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Conteudo> conteudos = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Curso> cursos = new ArrayList<>();
	
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
	
	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
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
