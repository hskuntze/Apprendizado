package br.edu.infnet.Apprendizado.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.Apprendizado.exceptions.TempoLimiteInvalidoException;

@Entity
@Table(name = "tb_questionario")
public class Questionario extends Conteudo{
	private static final long serialVersionUID = 1L;
	
	@ElementCollection
	private Map<Integer, String> questoes = new HashMap<>();
	@ElementCollection
	private Map<Integer, String> respostas = new HashMap<>();
	private Integer tempoLimite;
	
	public Questionario() {
	}

	public Questionario(Long id, String titulo, String desc, Map<Integer, String> questoes, Map<Integer, String> respostas, Integer tempoLimite) {
		super(id, titulo, desc);
		this.questoes = questoes;
		this.respostas = respostas;
		this.tempoLimite = tempoLimite;
	}

	/*
	 * Perguntas para o professor na próxima aula:
	 * O Map também só define o 'get'? 
	 */
	public Map<Integer, String> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Map<Integer, String> questoes) {
		this.questoes = questoes;
	}
	
	@ElementCollection
	public Map<Integer, String> getRespostas() {
		return respostas;
	}

	public void setRespostas(Map<Integer, String> respostas) {
		this.respostas = respostas;
	}

	public Integer getTempoLimite() {
		return tempoLimite;
	}

	public void setTempoLimite(Integer tempoLimite) {
		this.tempoLimite = tempoLimite;
	}

	@Override
	public void imprimir() {
		System.out.println(getId() + ", " + getTitulo() + ", " + getDescricao() + ", " + getTempoLimite() + ", " + getQuestoes() + ", " + getRespostas());
	}

	@Override
	public String toString() {
		return "Questionario questoes=" + questoes + ", respostas=" + respostas + ", tempoLimite=" + tempoLimite + "; " + super.toString();
	}

	@Override
	public String apurar() throws TempoLimiteInvalidoException {
		if(tempoLimite <= 30) {
			throw new TempoLimiteInvalidoException("Tempo limite mínimo de 30 minutos.");
		}
		return this.getClass().getSimpleName() + " " + this.getId() + ", " + this.getTempoLimite() + " minutos.";
	}
}
