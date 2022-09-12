package br.edu.infnet.Apprendizado.app;

import java.util.List;

import br.edu.infnet.Apprendizado.interfaces.IPrinter;

public class Classe implements IPrinter{
	private String nome;
	private List<Atributo> atributos;
	
	public Classe() {
	}

	public Classe(String nome) {
		this.nome = nome;
	}

	public Classe(String nome, List<Atributo> atributos) {
		this.nome = nome;
		this.atributos = atributos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

	@Override
	public void imprimir() {
		System.out.println("-> -> " + nome);
		for(Atributo a : atributos) {
			a.imprimir();
		}
	}
}
