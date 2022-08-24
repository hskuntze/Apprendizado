package br.edu.infnet.Apprendizado.test;

import br.edu.infnet.Apprendizado.interfaces.IPrinter;

public class AppImprimir {
	public static void relatorio(String mensagem, IPrinter printer) {
		System.out.println(mensagem);
	
		printer.imprimir();
	}
}
