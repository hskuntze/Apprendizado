package br.edu.infnet.Apprendizado.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.controller.ResponsavelController;
import br.edu.infnet.Apprendizado.entities.Responsavel;
import br.edu.infnet.Apprendizado.exceptions.ResponsavelInvalidoException;

@Component
public class ResponsavelTeste implements ApplicationRunner{
	@Override
	public void run(ApplicationArguments args) {
		System.out.println("\n---- Responsável ----");
		
		try {
			Responsavel r1 = new Responsavel("Ciclano Fulone", "ciclone@email.com");
			ResponsavelController.incluir(r1);
		} catch (ResponsavelInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Responsavel r2 = new Responsavel("", "arreni@email.com");
			ResponsavelController.incluir(r2);
		} catch (ResponsavelInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Responsavel r3 = new Responsavel("John Doe", "jnoe@email.com");
			ResponsavelController.incluir(r3);
		} catch (ResponsavelInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
