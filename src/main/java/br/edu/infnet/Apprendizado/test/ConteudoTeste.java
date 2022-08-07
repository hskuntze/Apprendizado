package br.edu.infnet.Apprendizado.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Conteudo;

@Component
public class ConteudoTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("---- Conteúdo ----");
		Long id = 1L;
		String titulo = "Conteúdo";
		String descricao = "Descrição do Conteúdo";
		
		Conteudo ct1 = new Conteudo(id, titulo, descricao);
		System.out.println(ct1);
	}
}
