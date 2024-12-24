package TP.Especial;

import java.util.ArrayList;
import java.util.Comparator;

import Condicion.Condicion;

public abstract class ElementodeBiblioteca {
	
	private String id;
	private String titulo;	
	
	protected ElementodeBiblioteca(String id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	
	public abstract int getCantidadLibros();
	
	public abstract ArrayList<String> getPalabrasClaves();
	
	public abstract ArrayList<Libro> buscar(Condicion c1, Comparator<Libro> comp);
	
	public abstract ElementodeBiblioteca getCopia(Condicion c1);
	
	public abstract ArrayList<ElementodeBiblioteca> getElementos();
	

}
