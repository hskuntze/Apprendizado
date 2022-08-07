package br.edu.infnet.Apprendizado.test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Curso;

@Component
public class CursoTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n---- Curso ----");
		Long id = 1L;
		String titulo = "Orientação a Objetos";
		Instant inicio = Instant.now();
		Instant fim = inicio.plus(15, ChronoUnit.DAYS);
		
		Curso c1 = new Curso(id, titulo, inicio, fim);
		System.out.println(c1 +"\n-------------");
		
		Curso c2 = new Curso();
		c2.setId(2L);
		c2.setTitulo("Linguagem Java com Ecossistema Spring");
		c2.setInicio(Instant.now());
		c2.setFim(c2.getInicio().plus(10, ChronoUnit.HOURS).plus(5, ChronoUnit.DAYS));
		
		System.out.println(c2 +"\n-------------");
		
		Curso c3 = new Curso();
		c3.setId(2L);
		c3.setTitulo("Docker com Kubernetes");
		c3.setInicio(Instant.now());
		c3.setFim(c2.getInicio().plus(2, ChronoUnit.HOURS).plus(2, ChronoUnit.DAYS));
		
		System.out.println(c3);
	}
}
