package TP.Especial;

import java.util.ArrayList;

public class ConjuntoLibroEspecial extends ConjuntoLibro {
	
	private final int MAX;
	
	
	
	public ConjuntoLibroEspecial(String id, String titulo, int max){
		super(id, titulo);
		this.MAX = max;
	}
	
	
	
	protected ConjuntoLibro nuevaCopia() {
		return new ConjuntoLibroEspecial(this.getID(), this.getTitulo(), this.MAX);
	}
	
	
	
	public ArrayList<String> getPalabrasClaves(){
		ArrayList<String> auxPalabrasClaves = new ArrayList<String>();
		ArrayList<String> palabras = new ArrayList<String>();
		ArrayList<Integer> cantPalabras = new ArrayList<Integer>();

		for(ElementodeBiblioteca o : elementos) 
			auxPalabrasClaves.addAll(o.getPalabrasClaves());
		
		for(String palabra : auxPalabrasClaves) {
			int contador = 0;
			for(String aux : auxPalabrasClaves) { 
				if (palabra == aux)
					contador++;
			}
			if(! palabras.contains(palabra)) {
				palabras.add(palabra);
				cantPalabras.add(contador);
			}	
		}
		return cargarSalida(palabras, cantPalabras);
	}
	
	
	
	private int contar (ArrayList<Integer> a) {
		int mayor = 0;
		for(int e : a) {
			if (e > mayor)
				mayor = e;
		}
		return mayor;
	}
	
	
	private ArrayList<String> cargarSalida(ArrayList<String> palabras, ArrayList<Integer> cantPalabras){
		ArrayList<String> salida = new ArrayList<String>();
		if(MAX <= palabras.size()) {
			for(int i = 0; i< MAX; i++) {
				int mayor = contar(cantPalabras);
				int indice = cantPalabras.indexOf(mayor);
				String pal = palabras.get(indice);
				salida.add(pal);
				cantPalabras.remove(indice);
				palabras.remove(indice);	
			}
			return salida;
		}
		else
			return palabras;
		
		
	}
	
}
