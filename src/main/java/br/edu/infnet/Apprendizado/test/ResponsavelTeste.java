package br.edu.infnet.Apprendizado.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Responsavel;
import br.edu.infnet.Apprendizado.exceptions.ResponsavelInvalidoException;
import br.edu.infnet.Apprendizado.services.ResponsavelService;

@Component
public class ResponsavelTeste implements ApplicationRunner{
	
	@Autowired
	private ResponsavelService service;
	
	@Override
	public void run(ApplicationArguments args) {
		System.out.println("\n---- Responsável ----");
		
		String dir = "D:/hskun/Documents/";
		String file = "responsaveis.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(dir+file))) {
			String line = br.readLine();
			while(line != null) {
				try {
					String[] fields = line.split(";");
					
					Responsavel r = new Responsavel(fields[0], fields[1]);
					
					service.incluir(r);
				} catch (ResponsavelInvalidoException e) {
					System.out.println("[ERROR - CURSO] " + e.getMessage());
				}
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
