package Condicion;

import TP.Especial.Libro;

public class CondicionAutor extends Condicion {

	private String autor;
	
	public CondicionAutor(String autor) {
		this.autor = autor;
	}
	

	public boolean cumple(Libro libro) {
		return libro.getAutores().toUpperCase().contains(autor.toUpperCase());
	}

}
