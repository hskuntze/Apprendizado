package br.edu.infnet.Apprendizado.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.controller.ResponsavelController;
import br.edu.infnet.Apprendizado.entities.Responsavel;

@Component
public class ResponsavelTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n---- Responsável ----");
		Responsavel r1 = new Responsavel();
		r1.setNome("Ciclano Fulone");
		r1.setEmail("ciclone@email.com");
		ResponsavelController.incluir(r1);
		
		Responsavel r2 = new Responsavel();
		r2.setNome("Arrebo Loeni");
		r2.setEmail("arreni@email.com");
		ResponsavelController.incluir(r2);
		
		Responsavel r3 = new Responsavel();
		r3.setNome("John Doe");
		r3.setEmail("jnoe@email.com");
		ResponsavelController.incluir(r3);
	}
}
