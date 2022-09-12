package br.edu.infnet.Apprendizado.exceptions;

public class UsuarioInvalidoException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public UsuarioInvalidoException(String msg) {
		super(msg);
	}
}
