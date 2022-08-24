package br.edu.infnet.Apprendizado.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.controller.QuestionarioController;
import br.edu.infnet.Apprendizado.entities.Questionario;

@Component
@Order(3)
public class QuestionarioTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n---- Questionário ----");
		Questionario q1 = new Questionario();
		q1.setTitulo("Questionário 1");
		q1.setDescricao("Descrição do questionário 1");
		q1.setTempoLimite(30);
		
		Map<Integer, String> questoes1 = new HashMap<>();
		questoes1.put(1, "Qual a cor do cavalo branco de Napoleão?");
		questoes1.put(2, "Qual a capital da Turquia?");
		questoes1.put(3, "O que comem os três tigres tristes?");
		questoes1.put(4, "Onde está o Wally?");
		q1.setQuestoes(questoes1);
		
		Map<Integer, String> respostas1 = new HashMap<>();
		respostas1.put(1, "Amarelo");
		respostas1.put(2, "Ancara");
		respostas1.put(3, "Três pratos de trigo");
		respostas1.put(4, "Boa pergunta");
		q1.setRespostas(respostas1);
		
		QuestionarioController.incluir(q1);
		
		Questionario q2 = new Questionario();
		q2.setTitulo("Questionário 2");
		q2.setDescricao("Descrição do questionário 2");
		q2.setTempoLimite(60);
		
		Map<Integer, String> questoes2 = new HashMap<>();
		questoes2.put(1, "Vivamus sit amet quam vel est congue.");
		questoes2.put(2, "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet.");
		q2.setQuestoes(questoes2);
		
		Map<Integer, String> respostas2 = new HashMap<>();
		respostas2.put(1, "Dolorem ipsum quia dolor sit amet.");
		respostas2.put(2, "Praesent pharetra, eros id laoreet gravida, ante.");
		q2.setRespostas(respostas2);
		
		QuestionarioController.incluir(q2);
		
		Questionario q3 = new Questionario();
		q3.setTitulo("Questionário 3");
		q3.setDescricao("Descrição do questionário 3");
		q3.setTempoLimite(120);
		
		Map<Integer, String> questoes3 = new HashMap<>();
		questoes3.put(1, "Vivamus sit amet quam vel est congue.");
		questoes3.put(2, "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet.");
		q3.setQuestoes(questoes3);
		
		Map<Integer, String> respostas3 = new HashMap<>();
		respostas3.put(1, "Dolorem ipsum quia dolor sit amet.");
		respostas3.put(2, "Praesent pharetra, eros id laoreet gravida, ante.");
		q3.setRespostas(respostas3);
		
		QuestionarioController.incluir(q3);
	}
}
