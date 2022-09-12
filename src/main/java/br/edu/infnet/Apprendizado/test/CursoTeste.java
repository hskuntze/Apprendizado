package br.edu.infnet.Apprendizado.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Conteudo;
import br.edu.infnet.Apprendizado.entities.Curso;
import br.edu.infnet.Apprendizado.entities.Questionario;
import br.edu.infnet.Apprendizado.entities.Responsavel;
import br.edu.infnet.Apprendizado.entities.Tarefa;
import br.edu.infnet.Apprendizado.entities.Video;
import br.edu.infnet.Apprendizado.exceptions.ConteudoInvalidoException;
import br.edu.infnet.Apprendizado.exceptions.ResponsavelInvalidoException;
import br.edu.infnet.Apprendizado.services.CursoService;

@Component
public class CursoTeste implements ApplicationRunner{

	@Autowired
	private CursoService service;
	
	@Override
	public void run(ApplicationArguments args) {
		Questionario q1 = new Questionario();
		q1.setTitulo("Questionário 1");
		q1.setDescricao("Descrição do questionário 1");
		q1.setTempoLimite(60);
		
		Map<Integer, String> questoes1 = new HashMap<>();
		questoes1.put(1, "Vivamus sit amet quam vel est congue.");
		questoes1.put(2, "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet.");
		q1.setQuestoes(questoes1);
		
		Map<Integer, String> respostas1 = new HashMap<>();
		respostas1.put(1, "Dolorem ipsum quia dolor sit amet.");
		respostas1.put(2, "Praesent pharetra, eros id laoreet gravida, ante.");
		q1.setRespostas(respostas1);
		
		Tarefa t1 = new Tarefa();
		t1.setTitulo("Tarefa 1");
		t1.setDescricao("Descrição da Tarefa 1");
		t1.setDataFinal(Instant.now().plus(10, ChronoUnit.DAYS));
		t1.setLinkTarefa("www.github.com/hskuntze/Apprendizado");
		t1.setEntregue(false);
		
		Tarefa t2 = new Tarefa();
		t2.setTitulo("Tarefa 1");
		t2.setDescricao("Descrição da Tarefa 1");
		t2.setDataFinal(Instant.now().plus(10, ChronoUnit.DAYS));
		t2.setLinkTarefa("www.github.com/hskuntze/Apprendizado");
		t2.setEntregue(false);
		
		Video v1 = new Video();
		v1.setTitulo("Vídeo 1");
		v1.setDescricao("Descrição do Vídeo 1");
		v1.setVideoUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		v1.setAcessadoEm(Instant.now().minus(1, ChronoUnit.HOURS));
		v1.setFinalizado(true);
		
		Set<Conteudo> conteudos1 = new HashSet<Conteudo>();
		conteudos1.add(t2);
		conteudos1.add(t1);
		conteudos1.add(v1);
		conteudos1.add(q1);
		
		System.out.println("\n---- Curso ----");
		
		String dir = "D:/hskun/Documents/";
		String file = "cursos.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(dir+file))) {
			String line = br.readLine();
			while(line != null) {
				try {
					String[] fields = line.split(";");
					
					Responsavel r1 = new Responsavel(fields[1], fields[2]);
					
					Curso c1 = new Curso(r1, conteudos1);
					c1.setTitulo(fields[0]);
					
					service.incluir(c1);
				} catch (ResponsavelInvalidoException e) {
					System.out.println("[ERROR - CURSO] " + e.getMessage());
				} catch (ConteudoInvalidoException e) {
					System.out.println("[ERROR - CURSO] " + e.getMessage());
				}
				
				System.out.println(line);
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
