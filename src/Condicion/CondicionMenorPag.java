package Condicion;

import TP.Especial.Libro;

public class CondicionMenorPag extends Condicion {

	private int paginas;
	
	
	public CondicionMenorPag(int pag) {
		this.paginas = pag;
	}
	
	

	public boolean cumple(Libro libro) {
		
		return libro.getCantPaginas() < this.paginas;
	}

}
