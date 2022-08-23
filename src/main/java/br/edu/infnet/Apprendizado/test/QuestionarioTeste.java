package br.edu.infnet.Apprendizado.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Questionario;

@Component
@Order(3)
public class QuestionarioTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n---- Questionário ----");
		Long id = 1L;
		String titulo = "Questionário 1";
		String descricao = "Descrição do Questionário 1";
		Map<Integer, String> questoes = new HashMap<>();
		Map<Integer, String> respostas = new HashMap<>();
		Integer tempoRestante = 180;
		
		questoes.put(1, "Qual a cor do cavalo branco de Napoleão?");
		questoes.put(2, "Qual a capital da Turquia?");
		questoes.put(3, "O que comem os três tigres tristes?");
		questoes.put(4, "Onde está o Wally?");
		
		respostas.put(1, "Amarelo");
		respostas.put(2, "Ancara");
		respostas.put(3, "Três pratos de trigo");
		respostas.put(4, "Boa pergunta");
		
		Questionario q1 = new Questionario(id, titulo, descricao, questoes, respostas, tempoRestante);
		System.out.println(q1 + "\n---------------");
		
		Questionario q2 = new Questionario();
		q2.setId(2L);
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
		
		System.out.println(q2);
	}
}
