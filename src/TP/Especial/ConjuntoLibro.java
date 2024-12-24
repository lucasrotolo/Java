package TP.Especial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Condicion.Condicion;


public class ConjuntoLibro extends ElementodeBiblioteca{
	
	protected ArrayList<ElementodeBiblioteca> elementos = new ArrayList<ElementodeBiblioteca>();

	
	
	public ConjuntoLibro(String id, String titulo) {
		super(id, titulo);
	}
	
	public void addElemento(ElementodeBiblioteca elemento) {
		if(!elementos.contains(elemento)) {
			elementos.add(elemento);
		}
	}
	
	
	public ArrayList<String> getPalabrasClaves(){
		ArrayList<String> auxPalabrasClaves = new ArrayList<String>();
		for(ElementodeBiblioteca o : elementos) { 
			for (String palabra : o.getPalabrasClaves())
				if(!auxPalabrasClaves.contains(palabra))
					auxPalabrasClaves.add(palabra);
		}
		return auxPalabrasClaves;
	}

	
	
	public int getCantidadLibros() {
		int total = 0;
		for(int i = 0; i < elementos.size(); i++)
			total = total + elementos.get(i).getCantidadLibros();
		
		return total;	
	}
	

	
	public ArrayList<Libro> buscar(Condicion c1, Comparator<Libro> comp){
		ArrayList<Libro> salida = new ArrayList<Libro>();
		for(ElementodeBiblioteca elem : elementos) {
			ArrayList<Libro> aux = elem.buscar(c1, comp);
			salida.addAll(aux);
		}
		Collections.sort(salida, comp);
		
		return salida;
	}
	
	
	public ElementodeBiblioteca getCopia(Condicion c1){
		ConjuntoLibro salida = this.nuevaCopia();
		boolean cargue = false;
		for(ElementodeBiblioteca elem : elementos) {
			ElementodeBiblioteca e = elem.getCopia(c1);
			if(e != null) {
				salida.addElemento(e);
				cargue = true;
			}
		}
		if (cargue == true)
			return salida;
		else 
			return null;
		
	}
	
	protected ConjuntoLibro nuevaCopia() {
		return new ConjuntoLibro(this.getID(), this.getTitulo());
	}
	
	
	public ArrayList<ElementodeBiblioteca> getElementos(){
		ArrayList<ElementodeBiblioteca> salida = new ArrayList<ElementodeBiblioteca>();
		salida.add(this);
		for(ElementodeBiblioteca e : elementos) {
			salida.addAll(e.getElementos());
		}
		return salida;
	}
	
	
	public boolean equals(Object o) {
		try {
			ConjuntoLibro conjunto = (ConjuntoLibro) o;
			return this.getID().equals(conjunto.getID()) && 
					this.getTitulo().toUpperCase().equals(conjunto.getTitulo().toUpperCase());
		}catch (Exception e) {
			return false;
		}
	}
	
	
	public String toString() {
		return "("+this.getTitulo()+")";
	}
	
}