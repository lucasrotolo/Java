package Comparacion;

import java.util.Comparator;

import TP.Especial.Libro;

public class ComparadorEditorial implements Comparator<Libro>{

	
	public int compare(Libro o1, Libro o2) {
		
		return o1.getEditorial().compareTo(o2.getEditorial());
	}

}
