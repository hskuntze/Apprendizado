package br.edu.infnet.Apprendizado.test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.controller.CursoController;
import br.edu.infnet.Apprendizado.entities.Curso;
import br.edu.infnet.Apprendizado.entities.Questionario;
import br.edu.infnet.Apprendizado.entities.Responsavel;
import br.edu.infnet.Apprendizado.entities.Tarefa;
import br.edu.infnet.Apprendizado.entities.Video;

@Component
public class CursoTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		Questionario q1 = new Questionario();
		q1.setId(1L);
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
		t1.setId(1L);
		t1.setTitulo("Tarefa 1");
		t1.setDescricao("Descrição da Tarefa 1");
		t1.setDataFinal(Instant.now().plus(10, ChronoUnit.DAYS));
		t1.setLinkTarefa("www.github.com/hskuntze/Apprendizado");
		t1.setEntregue(false);
		
		Tarefa t2 = new Tarefa();
		t2.setId(2L);
		t2.setTitulo("Tarefa 1");
		t2.setDescricao("Descrição da Tarefa 1");
		t2.setDataFinal(Instant.now().plus(10, ChronoUnit.DAYS));
		t2.setLinkTarefa("www.github.com/hskuntze/Apprendizado");
		t2.setEntregue(false);
		
		Video v1 = new Video();
		v1.setId(1L);
		v1.setTitulo("Vídeo 1");
		v1.setDescricao("Descrição do Vídeo 1");
		v1.setVideoUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		v1.setAcessadoEm(Instant.now().minus(1, ChronoUnit.HOURS));
		v1.setFinalizado(true);
		
		System.out.println("\n---- Curso ----");
		
		Responsavel r1 = new Responsavel(1L, "Fulaninho Rodrigues", "rod@email.com");
		Curso c1 = new Curso(r1);
		c1.setTitulo("Curso de Javascript");
		c1.getConteudos().add(q1);
		CursoController.incluir(c1);
		
		Responsavel r2 = new Responsavel(2L, "Ciclano Fulone", "ciclone@email.com");
		Curso c2 = new Curso(r2);
		c2.setTitulo("Linguagem Java com Ecossistema Spring");
		c2.getConteudos().add(q1);
		c2.getConteudos().add(v1);
		c2.getConteudos().add(t1);
		c2.getConteudos().add(t2);
		c2.getConteudos().add(t1);
		c2.getConteudos().add(t2);
		CursoController.incluir(c2);
		
		Responsavel r3 = new Responsavel(3L, "John Doe", "jnoe@email.com");
		Curso c3 = new Curso(r3);
		c3.setTitulo("Docker com Kubernetes");
		c3.getConteudos().add(v1);
		c3.getConteudos().add(q1);
		CursoController.incluir(c3);
	}
}
