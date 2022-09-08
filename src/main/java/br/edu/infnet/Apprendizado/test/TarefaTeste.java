package br.edu.infnet.Apprendizado.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.controller.TarefaController;
import br.edu.infnet.Apprendizado.entities.Tarefa;

@Component
@Order(2)
public class TarefaTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("\n---- Tarefa ----");
		String dir = "D:/hskun/Documents/";
		String file = "tarefas.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(dir + file))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(";");

				Tarefa t = new Tarefa();
				t.setTitulo(fields[0]);
				t.setDescricao(fields[1]);
				t.setEntregue(Boolean.valueOf(fields[2]));
				t.setDataFinal(Instant.parse(fields[3]));
				t.setLinkTarefa(fields[4]);

				TarefaController.incluir(t);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
