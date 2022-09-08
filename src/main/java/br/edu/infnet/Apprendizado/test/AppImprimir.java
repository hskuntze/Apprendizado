package br.edu.infnet.Apprendizado.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.edu.infnet.Apprendizado.interfaces.IPrinter;

public class AppImprimir {
	public static void relatorio(String mensagem, IPrinter printer) {
		System.out.println(mensagem);
	
		printer.imprimir();
	}
	
	public static void main(String[] args) {
		String dir = "D:/hskun/Documents/";
		String file = "cursos.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(dir+file))) {
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Finalizou");
	}
}
