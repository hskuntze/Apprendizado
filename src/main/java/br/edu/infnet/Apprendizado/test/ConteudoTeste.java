package br.edu.infnet.Apprendizado.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Conteudo;

@Component
public class ConteudoTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n---- Conteúdo ----");
		Long id = 1L;
		String titulo = "Conteúdo";
		String descricao = "Descrição do Conteúdo";
		
		Conteudo ct1 = new Conteudo(id, titulo, descricao);
		System.out.println(ct1 +"\n-------------");
		
		Conteudo ct2 = new Conteudo();
		ct2.setId(2L);
		ct2.setTitulo("Conteúdo 2");
		ct2.setDescricao("Descrição do Conteúdo 2");
		
		System.out.println(ct2 +"\n-------------");
		
		Conteudo ct3 = new Conteudo();
		ct3.setId(2L);
		ct3.setTitulo("Conteúdo 3");
		ct3.setDescricao("Descrição do Conteúdo 3");
		
		System.out.println(ct3);
	}
}
