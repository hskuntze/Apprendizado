package br.edu.infnet.Apprendizado.entities;

import java.util.Objects;

public class Conteudo {
	private Long id;
	private String titulo;
	private String descricao;
	
	public Conteudo() {
	}

	public Conteudo(Long id, String titulo, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Conteudo other = (Conteudo) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Título do conteúdo " + titulo + ", descrição: " + descricao + "]";
	}
}
