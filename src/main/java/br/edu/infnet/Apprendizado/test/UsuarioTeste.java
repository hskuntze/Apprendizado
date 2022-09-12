package br.edu.infnet.Apprendizado.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Usuario;
import br.edu.infnet.Apprendizado.services.UsuarioService;

@Component
public class UsuarioTeste implements ApplicationRunner{
	@Autowired
	private UsuarioService service;
	
	Usuario user;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		user = new Usuario();
		user.setId(1L);
		user.setNome("Hassan");
		user.setEmail("hssktz@emailtal.com");
		user.setSenha("123");
		
		service.incluir(user);
		
		String dir = "D:/hskun/Documents/";
		String file = "usuarios.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(dir+file))) {
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(";");
				
				user = new Usuario();
				user.setNome(fields[0]);
				user.setEmail(fields[1]);
				user.setSenha(fields[2]);
				
				service.incluir(user);
				
				line = br.readLine();
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println("[ERROR - ARQUIVO NÃO ENCONTRADO] "+e.getMessage());
		} catch(IOException e) {
			System.out.println("[ERROR - ENTRADA DE DADOS] "+e.getMessage());
		}
	}
	
}
