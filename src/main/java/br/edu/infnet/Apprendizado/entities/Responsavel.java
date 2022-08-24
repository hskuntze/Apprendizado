package br.edu.infnet.Apprendizado.entities;

import java.util.Objects;

import br.edu.infnet.Apprendizado.interfaces.IPrinter;

public class Responsavel implements IPrinter{
	private Long id;
	private String nome;
	private String email;
	
	public Responsavel() {
	}

	public Responsavel(Long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
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
		Responsavel other = (Responsavel) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public void imprimir() {
		System.out.println("#Responsável");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Responsavel id=" + id + "; " + nome + "; " + email;
	}

}
