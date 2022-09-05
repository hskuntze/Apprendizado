package br.edu.infnet.Apprendizado.exceptions;

public class VideoUrlInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public VideoUrlInvalidoException(String msg) {
		super(msg);
	}
}
