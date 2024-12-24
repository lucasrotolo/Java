package Condicion;

import TP.Especial.Libro;

public class CondicionEditorial extends Condicion {

	private String editorial;
	
	public CondicionEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	@Override
	public boolean cumple(Libro libro) {
		
		return libro.getEditorial().toUpperCase().contains(editorial.toUpperCase());
	}

}
