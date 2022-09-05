package br.edu.infnet.Apprendizado.test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.controller.TarefaController;
import br.edu.infnet.Apprendizado.entities.Tarefa;
import br.edu.infnet.Apprendizado.exceptions.LinkTarefaInvalidoException;

@Component
@Order(2)
public class TarefaTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("\n---- Tarefa ----");
		Tarefa t1 = new Tarefa();
		t1.setTitulo("Tarefa 1");
		t1.setDescricao("Descrição da Tarefa 1");
		t1.setDataFinal(Instant.now().plus(21, ChronoUnit.DAYS));
		t1.setLinkTarefa("www.github.com/hskuntze/Apprendizado");
		t1.setEntregue(false);
		
		try {
			System.out.println(t1.apurar());
			TarefaController.incluir(t1);
		} catch (LinkTarefaInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		Tarefa t2 = new Tarefa();
		t2.setTitulo("Tarefa 2");
		t2.setDescricao("Descrição da Tarefa 2");
		t2.setDataFinal(Instant.now().plus(1, ChronoUnit.DAYS));
		t2.setLinkTarefa(null);
		t2.setEntregue(false);
		
		try {
			System.out.println(t2.apurar());
			TarefaController.incluir(t2);
		} catch (LinkTarefaInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		Tarefa t3 = new Tarefa();
		t3.setTitulo("Tarefa 3");
		t3.setDescricao("Descrição da Tarefa 3");
		t3.setDataFinal(Instant.now().plus(2, ChronoUnit.HALF_DAYS));
		t3.setLinkTarefa("");
		t3.setEntregue(false);
		
		try {
			System.out.println(t3.apurar());
			TarefaController.incluir(t3);
		} catch (LinkTarefaInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
