package br.edu.infnet.Apprendizado.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.Apprendizado.entities.Video;
import br.edu.infnet.Apprendizado.services.VideoService;

@Component
@Order(1)
public class VideoTeste implements ApplicationRunner{
	
	@Autowired
	private VideoService service;

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("\n---- Vídeo ----");
		String dir = "D:/hskun/Documents/";
		String file = "videos.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(dir + file))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(";");

				Video v = new Video();
				v.setTitulo(fields[0]);
				v.setDescricao(fields[1]);
				v.setVideoUrl(fields[2]);
				v.setFinalizado(Boolean.valueOf(fields[3]));
				v.setAcessadoEm(Instant.parse(fields[4]));
				
				service.incluir(v);
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
