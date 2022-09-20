package br.edu.infnet.Apprendizado.entities;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import br.edu.infnet.Apprendizado.exceptions.ResponsavelInvalidoException;
import br.edu.infnet.Apprendizado.interfaces.IPrinter;

public class Curso implements IPrinter{
	
	private Long id;
	private String titulo;
	private Instant inicio;
	private Instant fim;
	
	//ORM pendente
	private Responsavel responsavel;
	
	//ORM pendente
	private Set<Conteudo> conteudos = new HashSet<>();
	
	public Curso() {
	}
	
	public Curso(Responsavel responsavel) {
		inicio = Instant.now();
		fim = inicio.plus(60, ChronoUnit.DAYS);
		this.responsavel = responsavel;
	}

	public Curso(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
		inicio = Instant.now();
		fim = inicio.plus(60, ChronoUnit.DAYS);
	}
	
	public Curso(Long id, String titulo, Responsavel responsavel) {
		this.id = id;
		this.titulo = titulo;
		inicio = Instant.now();
		fim = inicio.plus(60, ChronoUnit.DAYS);
		this.responsavel = responsavel;
	}

	public Curso(Long id, String titulo, Responsavel responsavel, Set<Conteudo> conteudos) {
		this.id = id;
		this.titulo = titulo;
		inicio = Instant.now();
		fim = inicio.plus(60, ChronoUnit.DAYS);
		this.responsavel = responsavel;
		this.conteudos = conteudos;
	}
	
	public Curso(Responsavel responsavel, Set<Conteudo> conteudos) throws ResponsavelInvalidoException {
		inicio = Instant.now();
		fim = inicio.plus(60, ChronoUnit.DAYS);
		
		if(responsavel == null) {
			throw new ResponsavelInvalidoException("Responsável com dados inválidos.");
		}
		this.responsavel = responsavel;
		this.conteudos = conteudos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Instant getInicio() {
		return inicio;
	}

	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}

	public Instant getFim() {
		return fim;
	}

	public void setFim(Instant fim) {
		this.fim = fim;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public void setConteudos(Set<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public Set<Conteudo> getConteudos() {
		return conteudos;
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
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public void imprimir() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Curso id=" + id + "; " + titulo + "; " + inicio + "; " + fim + "; "
				+ responsavel + "; " + conteudos.size();
	}
}
