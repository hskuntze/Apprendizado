package br.edu.infnet.Apprendizado.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.app.Atributo;
import br.edu.infnet.Apprendizado.app.Classe;
import br.edu.infnet.Apprendizado.app.Projeto;
import br.edu.infnet.Apprendizado.services.AppService;

@Component
public class AppTeste implements ApplicationRunner{
	
	@Autowired
	private AppService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		String dir = "D:/hskun/Documents/";
		String file = "detalhesProjeto.txt";
		
		List<Classe> classes = null;
		List<Atributo> atributos = null;
		Projeto p = null;
		Classe c = null;
		Atributo a = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(dir+file))) {
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(";");
				
				switch(fields[0].toUpperCase()) {
					case "P":
						classes = new ArrayList<Classe>();
						p = new Projeto();
						p.setNome(fields[1]);
						p.setDescricao(fields[2]);
						p.setClasses(classes);
						break;
						
					case "C":
						atributos = new ArrayList<Atributo>();
						c = new Classe();
						c.setNome(fields[1]);
						c.setAtributos(atributos);
						classes.add(c);
						break;
						
					case "A":
						a = new Atributo();
						a.setNome(fields[1]);
						a.setTipo(fields[2]);
						a.setDescricao(fields[3]);
						atributos.add(a);
						break;
						
					default: 
						System.out.println("Opção inválida.");
						break;
				}
				
				line = br.readLine();
			}
			service.incluir(p);
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println("[ERROR - ARQUIVO NÃO ENCONTRADO] "+e.getMessage());
		} catch(IOException e) {
			System.out.println("[ERROR - ENTRADA DE DADOS] "+e.getMessage());
		}
	}
}
