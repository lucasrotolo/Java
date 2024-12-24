package Condicion;

import TP.Especial.Libro;

public class CondicionNot extends Condicion {

	private Condicion c1;

	
	public CondicionNot(Condicion c1) {
		this.c1 = c1;
	}
	
	public boolean cumple(Libro libro) {
		
		return (!this.c1.cumple(libro));
	}

}
