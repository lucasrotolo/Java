package Comparacion;

import java.util.Comparator;

import TP.Especial.Libro;

public class ComparadorCompuesto implements Comparator<Libro>{

	private Comparator<Libro> comp1;
	private Comparator<Libro> comp2;
	
	
	public ComparadorCompuesto(Comparator<Libro> comp1, Comparator<Libro> comp2) {
		this.comp1 = comp1;
		this.comp2 = comp2;
	}
	
	
	public int compare(Libro o1, Libro o2) {
		
		int aux = this.comp1.compare(o1, o2);
		if (aux != 0)
			return aux;
		else
			return this.comp2.compare(o1, o2);
	}

}
