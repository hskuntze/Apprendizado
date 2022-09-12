package br.edu.infnet.Apprendizado.services;

import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.app.Projeto;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class AppService {
	
	private Projeto projeto;
	
	public void incluir(Projeto projeto) {
		this.projeto = projeto;
		AppImprimir.relatorio("Detalhes do projeto", projeto);
	}

	public Projeto getProjeto() {
		return projeto;
	}
}
