package TP.Especial;


import Comparacion.ComparadorLanzamiento;
import Condicion.*;

import java.util.ArrayList;


@SuppressWarnings("unused")
public class Administrador {

	public static void main (String[] args) {

		Libro l1 = new Libro("1", "Tipo de Metodologias", "Julio Verne", 200, "Atlantida", "2004");
		Libro l2 = new Libro("2", "Intro prog 1", "Autor", 100, "santillana", "2002");
		Libro l3 = new Libro("3", "Intro prog 2", "Autor", 200, "santillana", "2003");
		Libro l4 = new Libro("4", "Prog Orientada a objetos ", "Autor", 300, "santillana", "2006");
		Libro l5 = new Libro("5", "Tipo de Metodologias", "Horacio Quiroga", 190, "Atlantida", "2010");
		Libro l6 = new Libro("6", "Harry PotTer", "J.K Rowling", 250, "santillana", "2009");
		Libro l7 = new Libro("7", "Harry", "J.K Rowling", 250, "santillana", "2012");


		l1.addPalabraClave("historias");
		l2.addPalabraClave("pilas, filas y arreglos en programacion");
		l3.addPalabraClave("punteros en programacion");
		l4.addPalabraClave("composite");
		l5.addPalabraClave("objetos");
		l6.addPalabraClave("historias");
		l7.addPalabraClave("historias");
		l1.addPalabraClave("composite");




		ConjuntoLibro c1 = new ConjuntoLibro("A1", "Conjunto1");
		ConjuntoLibro c2 = new ConjuntoLibro("A2", "Conjunto2");
		ConjuntoLibro c3 = new ConjuntoLibro("A3", "Conjunto3");


		c2.addElemento(l1);
		c2.addElemento(l2);
		c2.addElemento(l3);
		c3.addElemento(l4);
		c3.addElemento(l5);
		c3.addElemento(l6);
		c3.addElemento(l7);

		c1.addElemento(c2);
		c1.addElemento(c3);


		CondicionAutor julioVerne = new CondicionAutor("julio VERNE");
		CondicionAutor horacio = new CondicionAutor("horacio QUIroga");
		CondicionAutor rowling = new CondicionAutor("J.K Rowling");

		CondicionTitulo contieneMetodo = new CondicionTitulo("metodologias");
		CondicionTitulo contienePotter = new CondicionTitulo("potter");

		CondicionTema programacion = new CondicionTema("programacion");
		CondicionTema objetos = new CondicionTema("objetos");

		CondicionEditorial atlantida = new CondicionEditorial("atlantida");
		CondicionMenorPag menos200 = new CondicionMenorPag(200);

		CondicionFecha pos2010 = new CondicionFecha("2010");

		ComparadorLanzamiento porlanzamiento = new ComparadorLanzamiento();



		ArrayList<Libro> listbusqueda = new ArrayList<Libro>();


		System.out.println("Buscar los libros del autor Julio Verne");
		listbusqueda = c1.buscar(julioVerne, porlanzamiento);
		for(int i = 0; i<listbusqueda.size(); i++)
			System.out.println(listbusqueda.get(i));
		System.out.println("-----------------------------------");


		System.out.println("Buscar los libros de menos de 200 páginas");
		listbusqueda = c1.buscar(menos200, porlanzamiento);
		for(int i = 0; i<listbusqueda.size(); i++)
			System.out.println(listbusqueda.get(i));
		System.out.println("-----------------------------------");


		System.out.println("Buscar los libros que traten el tema programación");
		listbusqueda = c1.buscar(programacion, porlanzamiento);
		for(int i = 0; i<listbusqueda.size(); i++)
			System.out.println(listbusqueda.get(i));
		System.out.println("-----------------------------------");


		System.out.println("Buscar los libros cuyo autor es “Horacio Quiroga” y su editorial es Atlántida");
		CondicionAnd condand = new CondicionAnd(horacio, atlantida);
		listbusqueda = c1.buscar(condand, porlanzamiento);
		for(int i = 0; i<listbusqueda.size(); i++)
			System.out.println(listbusqueda.get(i));
		System.out.println("-----------------------------------");


		System.out.println("Buscar los libros cuyo título contiene la palabra “metodologías” pero no\n" +
				"contienen la palabra “objetos” en las palabras clave");
		CondicionNot condnot = new CondicionNot(objetos);
		CondicionAnd condand2 = new CondicionAnd(contieneMetodo, condnot);
		listbusqueda = c1.buscar(condand2, porlanzamiento);
		for(int i = 0; i<listbusqueda.size(); i++)
			System.out.println(listbusqueda.get(i));
		System.out.println("-----------------------------------");


		System.out.println("Buscar los libros cuya autora es “J.K Rowling”, no contiene la palabra “Potter”\n" +
				"en el título, y el año de publicación es posterior a 2010");//No funciona la comparacion de fechas con string
		CondicionNot condnot2 = new CondicionNot(contienePotter);
		CondicionAnd condand3 = new CondicionAnd(rowling, condnot2);
		CondicionAnd condand4 = new CondicionAnd(condand3, pos2010);
		listbusqueda = c1.buscar(condand4, porlanzamiento);
		for(int i = 0; i<listbusqueda.size(); i++)
			System.out.println(listbusqueda.get(i));
		System.out.println("-----------------------------------");


		System.out.println("Cantidad de Libros en cada grupo");
		int cant = c1.getCantidadLibros();
		int cant2 = c2.getCantidadLibros();
		int cant3 = c3.getCantidadLibros();
		System.out.println("Grupo:"+c1.getTitulo()+" "+ cant );
		System.out.println("Grupo:"+c2.getTitulo()+" "+ cant2 );
		System.out.println("Grupo:"+c3.getTitulo()+" "+ cant3 );
		System.out.println("-----------------------------------");


		System.out.println("Lista de palabras claves");
		ArrayList<String> palabras = new ArrayList<String>();
		palabras = c1.getPalabrasClaves();
		for(String pal : palabras)
			System.out.println(pal);
		System.out.println("-----------------------------------");


		System.out.println("Copia Restringida de grupos");
		CondicionAutor cn = new CondicionAutor("autor");
		ElementodeBiblioteca copiaC1 = c1.getCopia(cn);
		ArrayList<ElementodeBiblioteca> a = new ArrayList<ElementodeBiblioteca>();
		a = copiaC1.getElementos();
		for(ElementodeBiblioteca e : a)
			System.out.println(e);
		System.out.println("-----------------------------------");


		System.out.println("Copia Restringida de grupoESPECIAL");
		ConjuntoLibroEspecial ce = new ConjuntoLibroEspecial("especial", "especial", 2);
		ConjuntoLibroEspecial ce1 = new ConjuntoLibroEspecial("especial", "especial1", 2);
		ConjuntoLibroEspecial ce2 = new ConjuntoLibroEspecial("especial", "especial2", 2);

		ce1.addElemento(l1);
		ce1.addElemento(l2);
		ce1.addElemento(l3);
		ce1.addElemento(l4);
		ce2.addElemento(l5);
		ce2.addElemento(l6);
		ce2.addElemento(l7);

		ce.addElemento(ce1);
		ce.addElemento(ce2);

		CondicionAutor cn2 = new CondicionAutor("autor");
		ElementodeBiblioteca copiaEspecial = ce.getCopia(cn2);
		ArrayList<ElementodeBiblioteca> b = new ArrayList<ElementodeBiblioteca>();
		b = copiaEspecial.getElementos();
		for(ElementodeBiblioteca e : b)
			System.out.println(e);
		System.out.println("-----------------------------------");

		System.out.println("PALABRAS CLAVES ESPECIAL");
		ArrayList<String> c = new ArrayList<String>();
		c = ce.getPalabrasClaves();
		for(String e : c)
			System.out.println(e);
		System.out.println("-----------------------------------");
	}

}
