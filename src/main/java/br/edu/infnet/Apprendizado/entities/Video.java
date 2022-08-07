package br.edu.infnet.Apprendizado.entities;

import java.time.Instant;

public class Video extends Conteudo{
	private String videoUrl;
	private boolean finalizado;
	private Instant acessadoEm;
	
	public Video() {
	}

	public Video(Long id, String titulo, String desc, String videoUrl, boolean finalizado, Instant acessadoEm) {
		super(id, titulo, desc);
		this.videoUrl = videoUrl;
		this.finalizado = finalizado;
		this.acessadoEm = acessadoEm;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Instant getAcessadoEm() {
		return acessadoEm;
	}

	public void setAcessadoEm(Instant acessadoEm) {
		this.acessadoEm = acessadoEm;
	}

	@Override
	public String toString() {
		return "Video " + videoUrl + "; " + finalizado + "; " + acessadoEm + "; " + super.toString();
	}
}
