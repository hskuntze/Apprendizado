package br.edu.infnet.Apprendizado.test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.controller.VideoController;
import br.edu.infnet.Apprendizado.entities.Video;

@Component
@Order(1)
public class VideoTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("\n---- Vídeo ----");
		Video v1 = new Video();
		v1.setTitulo("Vídeo 1");
		v1.setDescricao("Descrição do Vídeo 1");
		v1.setVideoUrl("https://www.youtube.com/watch?v=8YaOWBvx_Ms");
		v1.setAcessadoEm(Instant.now().minus(1, ChronoUnit.HOURS));
		v1.setFinalizado(true);
		
		try {
			System.out.println(v1.apurar());
			VideoController.incluir(v1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Video v2 = new Video();
		v2.setTitulo("Vídeo 2");
		v2.setDescricao("Descrição do Vídeo 2");
		v2.setVideoUrl("");
		v2.setAcessadoEm(Instant.now().minus(62, ChronoUnit.HOURS));
		v2.setFinalizado(true);
		
		try {
			System.out.println(v2.apurar());
			VideoController.incluir(v2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Video v3 = new Video();
		v3.setTitulo("Vídeo 3");
		v3.setDescricao("Descrição do Vídeo 3");
		v3.setVideoUrl(null);
		v3.setAcessadoEm(Instant.now().minus(41, ChronoUnit.HOURS));
		v3.setFinalizado(true);
		
		try {
			System.out.println(v3.apurar());
			VideoController.incluir(v3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
