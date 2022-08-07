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
		System.out.println("\n---- Tarefa ----");
		Long id = 1L;
		String titulo = "Tarefa 1";
		String descricao = "Descrição da Tarefa 1";
		boolean entregue = true;
		Instant dataFinal = Instant.now().plus(1, ChronoUnit.DAYS);
		String linkTarefa = "www.github.com/hskuntze/Apprendizado";
		
		Tarefa t1 = new Tarefa(id, titulo, descricao, entregue, dataFinal, linkTarefa);
		System.out.println(t1 +"\n-------------");
		
		Tarefa t2 = new Tarefa();
		t2.setId(2L);
		t2.setTitulo("Tarefa 2");
		t2.setDescricao("Descrição da Tarefa 2");
		t2.setDataFinal(Instant.now().plus(1, ChronoUnit.DAYS));
		t2.setLinkTarefa("www.github.com/hskuntze/Apprendizado");
		t2.setEntregue(false);
		
		System.out.println(t2 +"\n-------------");
		
		Tarefa t3 = new Tarefa();
		t3.setId(2L);
		t3.setTitulo("Tarefa 3");
		t3.setDescricao("Descrição da Tarefa 3");
		t3.setDataFinal(Instant.now().plus(2, ChronoUnit.HALF_DAYS));
		t3.setLinkTarefa("www.github.com/hskuntze/Apprendizado");
		t3.setEntregue(false);
		
		System.out.println(t3 +"\n-------------");
	}
}
