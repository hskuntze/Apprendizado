package br.edu.infnet.Apprendizado.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
import br.edu.infnet.Apprendizado.exceptions.ResponsavelInvalidoException;
import br.edu.infnet.Apprendizado.services.CursoService;

@Component
public class CursoTeste implements ApplicationRunner{

	@Autowired
	private CursoService service;
	
	@Override
	public void run(ApplicationArguments args) {
		Set<Conteudo> conteudos = null;
		List<Curso> cursos = new ArrayList<>();
		
		System.out.println("\n---- Curso ----");
		
		String dir = "D:/hskun/Documents/";
		String file = "cursos.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(dir+file))) {
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(";");
				
				switch(fields[0].toUpperCase()) {
					case "C":
						try {
							conteudos = new HashSet<Conteudo>();
							Responsavel r = new Responsavel(fields[2], fields[3]);
							
							Curso c = new Curso(r, conteudos);
							c.setTitulo(fields[1]);
							
							cursos.add(c);
						} catch (ResponsavelInvalidoException e) {
							System.out.println("[ERROR - CURSO] " + e.getMessage());
						}
						break;
					case "Q":
						String[] qs = fields[4].split(",");
						Map<Integer, String> questoes = new HashMap<>();
		 				for(int i = 0; i < qs.length; i++) {
		 					String[] aux = qs[i].split("=");
		 					questoes.put(Integer.valueOf(aux[0]), aux[1]);
						}
		 				
		 				String[] rs = fields[5].split(",");
		 				Map<Integer, String> respostas = new HashMap<>();
		 				for(int j = 0; j < rs.length; j++) {
		 					String[] aux = rs[j].split("=");
		 					respostas.put(Integer.valueOf(aux[0]), aux[1]);
		 				}
		 				
		 				Questionario q = new Questionario();
		 				q.setTitulo(fields[1]);
		 				q.setDescricao(fields[2]);
		 				q.setTempoLimite(Integer.valueOf(fields[3]));
		 				q.setQuestoes(questoes);
		 				q.setRespostas(respostas);
						conteudos.add(q);
						break;
					case "T":
						Tarefa t = new Tarefa();
						t.setTitulo(fields[1]);
						t.setDescricao(fields[2]);
						t.setEntregue(Boolean.valueOf(fields[3]));
						t.setDataFinal(Instant.parse(fields[4]));
						t.setLinkTarefa(fields[5]);
						conteudos.add(t);
						break;
					case "V":
						Video v = new Video();
						v.setTitulo(fields[1]);
						v.setDescricao(fields[2]);
						v.setVideoUrl(fields[3]);
						v.setFinalizado(Boolean.valueOf(fields[4]));
						v.setAcessadoEm(Instant.parse(fields[5]));
						conteudos.add(v);
						break;
				}
				line = br.readLine();
			}
			for(Curso c : cursos) {
				service.incluir(c);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>> "+c.getId());
				System.out.println(">>>>>>>>>>>>>>>>>>>>>> "+c.getResponsavel());
				System.out.println(">>>>>>>>>>>>>>>>>>>>>> "+c.getConteudos().size());
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
