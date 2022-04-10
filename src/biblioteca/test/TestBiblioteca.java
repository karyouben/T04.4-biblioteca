package biblioteca.test;

import java.util.Map;

import fp.biblioteca.BibliotecaImpl;

public class TestBiblioteca {

	public static void main(String[] args) {
		List<Libro> libros = FactoriaLibro.creaLibros("./data/Libros.txt");
		BibliotecaImpl b = new BibliotecaImpl("ETSII","Sevilla");
		b.agregarLibros(libros);
		Map<String, Integer> m= b.contarLibrosPorAutor();
//		System.out.println(m);
		
		// 1 forma
		for(String autor: m.keySet()) {
			System.out.println(autor + "->" + m.get(autor));
		}
//		for k in m.keySet():
//			print(k+'->'+k['autor'])
		// 2º forma
//		for(Map.Entry<String,Integer> pareja : m.entrySet()) {
//			System.out.println(pareja.getKey()+ "->"+ pareja.getValue());
//		}

	}
	
	Integer numBestSellers = b.getNumBestSellers();
	System.out.println(String.format("Hay %d bestsellers", numBestSellers));
	
	Integer totalPaginas = b.getTotalPaginass("J.K.Rowling");
	System.out.println(totalPaginas);
	for(String autor:b.getAutores()) {
		System.out.println(autor);
	}
	

}
