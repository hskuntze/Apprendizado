package br.edu.infnet.Apprendizado.entities;

import java.time.Instant;

import br.edu.infnet.Apprendizado.exceptions.VideoUrlInvalidoException;

public class Video extends Conteudo {
	private static final long serialVersionUID = 1L;
	
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
	public void imprimir() {
		System.out.println(getId() + ", " + getTitulo() + ", " + getDescricao() + ", " + getVideoUrl() + ", " + getAcessadoEm() + ", " + isFinalizado());
	}

	@Override
	public String toString() {
		return "Video videoUrl=" + videoUrl + ", finalizado=" + finalizado + ", acessadoEm=" + acessadoEm + "; " + super.toString();
	}

	@Override
	public String apurar() throws VideoUrlInvalidoException {
		if(getVideoUrl() == null || getVideoUrl().isBlank()) {
			throw new VideoUrlInvalidoException("Link do vídeo não pode estar em branco.");
		}
		return getClass().getSimpleName() + " " + getId() + ", link do vídeo: " + getVideoUrl();
	}
}
