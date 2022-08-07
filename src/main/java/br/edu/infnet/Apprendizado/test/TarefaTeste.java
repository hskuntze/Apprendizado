package br.edu.infnet.Apprendizado.test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Tarefa;

@Component
public class TarefaTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("---- Tarefa ----");
		Long id = 5L;
		String titulo = "Tarefa 4";
		String descricao = "Descrição da Tarefa 4";
		boolean entregue = true;
		Instant dataFinal = Instant.now().plus(1, ChronoUnit.DAYS);
		String linkTarefa = "www.github.com/hskuntze/Apprendizado";
		
		Tarefa t1 = new Tarefa(id, titulo, descricao, entregue, dataFinal, linkTarefa);
		System.out.println(t1);
	}
}
