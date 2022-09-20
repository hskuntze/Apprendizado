package br.edu.infnet.Apprendizado.entities;

import java.time.Instant;

import br.edu.infnet.Apprendizado.exceptions.LinkTarefaInvalidoException;

public class Tarefa extends Conteudo{
	private static final long serialVersionUID = 1L;
	
	private boolean entregue;
	private Instant dataFinal;
	private String linkTarefa;
	
	public Tarefa() {
	}

	public Tarefa(Long id, String titulo, String desc, boolean entregue, Instant dataFinal, String linkTarefa) {
		super(id, titulo, desc);
		this.entregue = entregue;
		this.dataFinal = dataFinal;
		this.linkTarefa = linkTarefa;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

	public Instant getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Instant dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getLinkTarefa() {
		return linkTarefa;
	}

	public void setLinkTarefa(String linkTarefa) {
		this.linkTarefa = linkTarefa;
	}
	
	@Override
	public void imprimir() {
		System.out.println(getId() + ", " + getTitulo() + ", " + getDescricao() + ", " + getLinkTarefa() + ", " + getDataFinal() + ", " + isEntregue());
	}

	@Override
	public String toString() {
		return "Tarefa entregue=" + entregue + ", dataFinal=" + dataFinal + ", linkTarefa=" + linkTarefa + "; " + super.toString();
	}

	@Override
	public String apurar() throws LinkTarefaInvalidoException {
		if(getLinkTarefa() == null || getLinkTarefa().isBlank()) {
			throw new LinkTarefaInvalidoException("Link da tarefa não pode estar em branco.");
		}
		return getClass().getName() + " " + getId() + ", " + getLinkTarefa();
	}
}
