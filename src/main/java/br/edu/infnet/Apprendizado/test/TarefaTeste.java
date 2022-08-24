package br.edu.infnet.Apprendizado.test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.controller.TarefaController;
import br.edu.infnet.Apprendizado.entities.Tarefa;

@Component
@Order(2)
public class TarefaTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n---- Tarefa ----");
		Tarefa t1 = new Tarefa();
		t1.setTitulo("Tarefa 1");
		t1.setDescricao("Descrição da Tarefa 1");
		t1.setDataFinal(Instant.now().plus(21, ChronoUnit.DAYS));
		t1.setLinkTarefa("www.github.com/hskuntze/Apprendizado");
		t1.setEntregue(false);
		TarefaController.incluir(t1);
		
		Tarefa t2 = new Tarefa();
		t2.setTitulo("Tarefa 2");
		t2.setDescricao("Descrição da Tarefa 2");
		t2.setDataFinal(Instant.now().plus(1, ChronoUnit.DAYS));
		t2.setLinkTarefa("www.github.com/hskuntze");
		t2.setEntregue(false);
		TarefaController.incluir(t2);
		
		Tarefa t3 = new Tarefa();
		t3.setTitulo("Tarefa 3");
		t3.setDescricao("Descrição da Tarefa 3");
		t3.setDataFinal(Instant.now().plus(2, ChronoUnit.HALF_DAYS));
		t3.setLinkTarefa("www.github.com/hskuntze/hklearn-frontend");
		t3.setEntregue(false);
		TarefaController.incluir(t3);
	}
}
