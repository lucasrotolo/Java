package Comparacion;

import java.util.Comparator;

import TP.Especial.Libro;

public class ComparadorAutor implements Comparator<Libro>{

	
	public int compare(Libro o1, Libro o2) {

		return o1.getAutores().compareTo(o2.getAutores());
	}
	
	

}
