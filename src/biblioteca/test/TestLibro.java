package biblioteca.test;

import java.time.LocalDate;

import fp.biblioteca.Libro;
import fp.biblioteca.TipoPrestamo;

public abstract class TestLibro {


	public static void main(String[] args) {
		Libro o1 = new Libro("3214","One Piece","Oda",421, LocalDate.of(2003, 2, 15), 24.99, 47000, TipoPrestamo.MENSUAL);
		System.out.println(o1);

	}

}
