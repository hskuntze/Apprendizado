package br.edu.infnet.Apprendizado.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Responsavel;

@Component
public class ResponsavelTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("---- Responsável ----");
		Long id = 1L;
		String nome = "Fulaninho Rodrigues";
		String email = "rod@email.com";
		
		Responsavel r1 = new Responsavel(id, nome, email);
		System.out.println(r1);
	}
}
