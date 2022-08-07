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
		System.out.println("---- Curso ----");
		Long id = 1L;
		String titulo = "Orientação a Objetos";
		Instant inicio = Instant.now();
		Instant fim = inicio.plus(15, ChronoUnit.DAYS);
		
		Curso c1 = new Curso(id, titulo, inicio, fim);
		System.out.println(c1);
	}
}
