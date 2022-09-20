package br.edu.infnet.Apprendizado.entities;

import java.util.Map;

import br.edu.infnet.Apprendizado.exceptions.TempoLimiteInvalidoException;

public class Questionario extends Conteudo{
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, String> questoes;
	private Map<Integer, String> respostas;
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
