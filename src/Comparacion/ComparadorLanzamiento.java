package Comparacion;

import java.util.Comparator;
import TP.Especial.Libro;


public class ComparadorLanzamiento implements Comparator<Libro>{

	
	public int compare(Libro o1, Libro o2) {
		
		return o1.getLanzamiento().compareTo(o2.getLanzamiento());
	
	}

	
}
