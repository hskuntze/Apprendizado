package br.edu.infnet.Apprendizado.test;

import br.edu.infnet.Apprendizado.entities.Conteudo;

public class AppConteudo {
	private String mensagem;
	
	//Conceito de encapsulamento
	public AppConteudo(String mensagem) {
		this.mensagem = mensagem;
	}
	
	//Conceito de encapsulamento
	public void relatorio(Conteudo conteudo) {
		System.out.println(mensagem);
		System.out.println(conteudo.imprimir());
	}
}
