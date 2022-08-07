package br.edu.infnet.Apprendizado.entities;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Curso {
	private Long id;
	private String titulo;
	private Instant inicio;
	private Instant fim;
	
	//ORM pendente
	private Responsavel responsavel;
	
	//ORM pendente
	private List<Conteudo> conteudos;
	
	public Curso() {
	}

	public Curso(Long id, String titulo, Instant inicio, Instant fim) {
		this.id = id;
		this.titulo = titulo;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Curso(Long id, String titulo, Instant inicio, Instant fim, Responsavel responsavel, List<Conteudo> conteudos) {
		this.id = id;
		this.titulo = titulo;
		this.inicio = inicio;
		this.fim = fim;
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

	public List<Conteudo> getConteudos() {
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
	public String toString() {
		return "Curso " + titulo + ", iniciado em " + inicio + ", finalizado em " + fim;
	}
}
