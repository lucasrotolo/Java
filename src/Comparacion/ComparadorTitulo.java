package Comparacion;

import java.util.Comparator;

import TP.Especial.Libro;

public class ComparadorTitulo implements Comparator<Libro>{

	
	public int compare(Libro o1, Libro o2) {
		return o1.getTitulo().compareTo(o2.getTitulo());
	}
	
	

}
