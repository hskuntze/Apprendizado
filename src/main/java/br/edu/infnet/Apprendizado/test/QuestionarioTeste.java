package br.edu.infnet.Apprendizado.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Questionario;

@Component
public class QuestionarioTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("---- Questionário ----");
		Long id = 2L;
		String titulo = "Questionário 2";
		String descricao = "Descrição do Questionário 2";
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
		System.out.println(q1);
	}
}
