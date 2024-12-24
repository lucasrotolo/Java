package TP.Especial;

import java.util.ArrayList;
import java.util.Comparator;

import Condicion.Condicion;

public class Libro extends ElementodeBiblioteca {
	
	
	private String autores;
	private int cantPaginas;
	private String editorial;
	private String lanzamiento;
	private ArrayList<String> palabrasClave = new ArrayList<String>();
	
	
	public Libro(String id, String titulo, String autores, int cantPaginas, String editorial, String lanzamiento){
		super(id, titulo);
		this.autores = autores;
		this.cantPaginas = cantPaginas;
		this.editorial = editorial;
		this.lanzamiento = lanzamiento;
	}

	
	public String getAutores() {
		return autores;
	}


	public int getCantPaginas() {
		return cantPaginas;
	}


	public String getEditorial() {
		return editorial;
	}
	


	public String getLanzamiento() {
		return lanzamiento;
	}
	
	
	public void addPalabraClave(String palabraClave) {
		if(!palabrasClave.contains(palabraClave))
			palabrasClave.add(palabraClave);
	}
	
	
	public ArrayList<String> getPalabrasClaves() {
		ArrayList<String> auxPalabrasClave = new ArrayList<String>();
		auxPalabrasClave.addAll(this.palabrasClave);
		return auxPalabrasClave;
		
	}
	
	
	public boolean equals(Object o) {
		try {
			Libro lib = (Libro) o;
			return this.getAutores().toUpperCase().equals(lib.getAutores().toUpperCase()) && 
					this.getTitulo().toUpperCase().equals(lib.getTitulo().toUpperCase());
		} catch(Exception e) {
			return false;
		}
	}
	
	
	public int getCantidadLibros() {
		return 1;
	}
	
	
	public ArrayList<Libro> buscar(Condicion c1, Comparator<Libro> comp){
		ArrayList<Libro> aux = new ArrayList<Libro>();	
		if(c1.cumple(this))
			aux.add(this);	
		return aux;
	}
	
	
	public String toString() {
		return "("+this.getLanzamiento()+")"+" "+super.getTitulo()+" "+"-"+" "+this.getAutores()+" "+"-"+" "+this.getEditorial();
	}
	
	
	
	public ElementodeBiblioteca getCopia(Condicion c1) {
		if(c1.cumple(this)) {
			Libro l1 = new Libro(this.getID(), this.getTitulo(), this.autores, this.cantPaginas, this.editorial, this.lanzamiento);
			return l1;
		}
		else
			return null;
	}
	
	
	public ArrayList<ElementodeBiblioteca> getElementos(){
		ArrayList<ElementodeBiblioteca> salida = new ArrayList<ElementodeBiblioteca>();
		salida.add(this);
		return salida;
	}

}
