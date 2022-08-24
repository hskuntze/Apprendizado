package br.edu.infnet.Apprendizado.entities;

import java.time.Instant;

public class Tarefa extends Conteudo{
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
	public void apurar() {
		System.out.println(getClass().getName());
		System.out.println(getClass().getInterfaces());
		System.out.println(getClass().getModifiers());
		System.out.println("---------------------------");
		System.out.println(getClass().getPackageName());
	}
}
