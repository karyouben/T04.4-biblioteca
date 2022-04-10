package fp.biblioteca;

import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaLibro {
	
	public static List<Libro> leeLibros(String fichero) {
		String msg = String.format("Error leyendo %s", fichero);
		List<String> lineas = Ficheros.leeFichero(msg, fichero);
		List<Libro> libros= new ArrayList<Libro>();
		lineas.remove(0);
		for(String cad: lineas) {
			libros.add(new Libro(cad));
		}
		return libros;
	}
	
	public static List<Libro> creaLibros(String fichero) {
		Checkers.checkNoNull(fichero);
		List<String> lineas = Ficheros.leeFichero(fichero,fichero);
		List<Libro> res = new ArrayList<Libro>();
		Boolean esPrimera= true;
		lineas.remove(0);
		for(String linea:lineas) {
			if(!esPrimera) {
				Libro l=new Libro(linea);			
			}else {
				esPrimera= false;			
			}
		}return res;
	}

}
