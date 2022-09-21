package br.edu.infnet.Apprendizado.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.edu.infnet.Apprendizado.exceptions.LinkTarefaInvalidoException;
import br.edu.infnet.Apprendizado.exceptions.TempoLimiteInvalidoException;
import br.edu.infnet.Apprendizado.exceptions.VideoUrlInvalidoException;
import br.edu.infnet.Apprendizado.interfaces.IPrinter;

@Entity
@Table(name = "tb_conteudo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conteudo implements IPrinter, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String titulo;
	private String descricao;
	
	public Conteudo() {
	}

	public Conteudo(Long id, String titulo, String descricao) {
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
	
	public abstract String apurar() throws TempoLimiteInvalidoException, LinkTarefaInvalidoException, VideoUrlInvalidoException;

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
		return "Conteudo id=" + id + ", titulo=" + titulo + ", descricao=" + descricao;
	}
}
