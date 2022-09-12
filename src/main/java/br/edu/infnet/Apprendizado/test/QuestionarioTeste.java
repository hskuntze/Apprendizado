package br.edu.infnet.Apprendizado.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Questionario;
import br.edu.infnet.Apprendizado.services.QuestionarioService;

@Component
@Order(3)
public class QuestionarioTeste implements ApplicationRunner{
	
	@Autowired
	private QuestionarioService service;

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("\n---- Questionário ----");
		
		String dir = "D:/hskun/Documents/";
		String file = "questionarios.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(dir+file))) {
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(";");
				
				String[] q = fields[3].split(",");
				Map<Integer, String> questoes = new HashMap<>();
 				for(int i = 0; i < q.length; i++) {
 					String[] aux = q[i].split("=");
 					questoes.put(Integer.valueOf(aux[0]), aux[1]);
				}
 				
 				String[] r = fields[4].split(",");
 				Map<Integer, String> respostas = new HashMap<>();
 				for(int j = 0; j < r.length; j++) {
 					String[] aux = r[j].split("=");
 					respostas.put(Integer.valueOf(aux[0]), aux[1]);
 				}
 				
 				Questionario q1 = new Questionario();
 				q1.setTitulo(fields[0]);
 				q1.setDescricao(fields[1]);
 				q1.setTempoLimite(Integer.valueOf(fields[2]));
 				q1.setQuestoes(questoes);
 				q1.setRespostas(respostas);
 				
 				service.incluir(q1);
				
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
