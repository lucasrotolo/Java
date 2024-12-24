package Condicion;

import TP.Especial.Libro;

public class CondicionFecha extends Condicion {

	
	private String fecha;
	
	public CondicionFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	public boolean cumple(Libro libro) {
		
		if(libro.getLanzamiento().compareTo(this.fecha) == -1)
			return true;
		else return false;

	}

}
