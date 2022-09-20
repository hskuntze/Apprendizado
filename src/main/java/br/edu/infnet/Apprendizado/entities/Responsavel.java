package br.edu.infnet.Apprendizado.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.infnet.Apprendizado.exceptions.ResponsavelInvalidoException;
import br.edu.infnet.Apprendizado.interfaces.IPrinter;

@Entity
@Table(name = "tb_responsavel")
public class Responsavel implements IPrinter{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	
	public Responsavel() {
	}

	public Responsavel(String nome, String email) throws ResponsavelInvalidoException{
		if((nome == null || nome.isBlank()) || (email == null || email.isBlank())) {
			throw new ResponsavelInvalidoException("Não é possível registrar um responsável com nome e/ou email vazios.");
		}
		
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
