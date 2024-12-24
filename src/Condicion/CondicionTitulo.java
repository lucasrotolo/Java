package Condicion;

import TP.Especial.Libro;

public class CondicionTitulo extends Condicion {

	private String titulo;
	
	public CondicionTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public boolean cumple(Libro libro) {
		
		return libro.getTitulo().toUpperCase().contains(titulo.toUpperCase());
	}

}
