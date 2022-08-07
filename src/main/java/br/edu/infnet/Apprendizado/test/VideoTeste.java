package br.edu.infnet.Apprendizado.test;

import java.time.Instant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Video;

@Component
public class VideoTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("---- Vídeo ----");
		Long id = 3L;
		String titulo = "Video 3";
		String descricao = "Descrição do Vídeo 3";
		String videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
		Instant acessadoEm = Instant.now();
		boolean finalizado = true;
		
		Video v1 = new Video(id, titulo, descricao, videoUrl, finalizado, acessadoEm);
		System.out.println(v1);
	}
}
