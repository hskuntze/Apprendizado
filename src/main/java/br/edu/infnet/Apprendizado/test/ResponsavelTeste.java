package br.edu.infnet.Apprendizado.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Responsavel;

@Component
public class ResponsavelTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n---- Responsável ----");
		Long id = 1L;
		String nome = "Fulaninho Rodrigues";
		String email = "rod@email.com";
		
		Responsavel r1 = new Responsavel(id, nome, email);
		System.out.println(r1 +"\n-------------");
		
		Responsavel r2 = new Responsavel();
		r2.setId(2L);
		r2.setNome("Ciclano Fulone");
		r2.setEmail("ciclone@email.com");
		
		System.out.println(r2 +"\n-------------");
		
		Responsavel r3 = new Responsavel();
		r3.setId(3L);
		r3.setNome("John Doe");
		r3.setEmail("jnoe@email.com");
		
		System.out.println(r3 +"\n-------------");
	}
}
