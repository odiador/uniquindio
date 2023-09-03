package co.edu.uniquindio.biblioteca.test;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.uniquindio.biblioteca.model.Libro;
import co.edu.uniquindio.biblioteca.model.Tipo;

public class LibroTest {

	@Test
	public void testSetAutor() {

		Libro libro = new Libro("a", "b", "c", "1", Tipo.BIOGRAFIA);

		libro.setAutor("Juan");

		assertEquals("Juan", libro.getAutor());

	}
}
