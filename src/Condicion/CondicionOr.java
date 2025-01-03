package Condicion;

import TP.Especial.Libro;

public class CondicionOr extends Condicion {

	private Condicion c1;
	private Condicion c2;
	
	public CondicionOr(Condicion c1, Condicion c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	@Override
	public boolean cumple(Libro libro) {
		
		return c1.cumple(libro) || c2.cumple(libro);
	}

}
