package br.edu.infnet.Apprendizado.test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Video;

@Component
@Order(1)
public class VideoTeste implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n---- Vídeo ----");
		Long id = 1L;
		String titulo = "Vídeo 1";
		String descricao = "Descrição do Vídeo 1";
		String videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
		Instant acessadoEm = Instant.now();
		boolean finalizado = true;
		
		Video v1 = new Video(id, titulo, descricao, videoUrl, finalizado, acessadoEm);
		AppImprimir.relatorio("Mensagemmm", v1);
		
		Video v2 = new Video();
		v2.setId(2L);
		v2.setTitulo("Vídeo 2");
		v2.setDescricao("Descrição do Vídeo 2");
		v2.setVideoUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		v2.setAcessadoEm(Instant.now().minus(1, ChronoUnit.HOURS));
		v2.setFinalizado(true);
		AppImprimir.relatorio("Mensagemmm2", v2);
		
		Video v3 = new Video();
		v3.setId(3L);
		v3.setTitulo("Vídeo 3");
		v3.setDescricao("Descrição do Vídeo 3");
		v3.setVideoUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		v3.setAcessadoEm(Instant.now().minus(1, ChronoUnit.HOURS));
		v3.setFinalizado(true);
		AppImprimir.relatorio("Mensagemmm3", v3);
	}
}
