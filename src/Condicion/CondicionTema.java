package Condicion;

import java.util.ArrayList;

import TP.Especial.Libro;

public class CondicionTema extends Condicion {

	private String temadelLibro;
	
	public CondicionTema(String temadelLibro) {
		this.temadelLibro = temadelLibro;
	}
	@Override
	public boolean cumple(Libro libro) {
		ArrayList<String> aux = libro.getPalabrasClaves();
		String palabra = "";
		if(aux != null)
			palabra = aux.get(0);
		
		return palabra.toUpperCase().contains(temadelLibro.toUpperCase());
	}

}
