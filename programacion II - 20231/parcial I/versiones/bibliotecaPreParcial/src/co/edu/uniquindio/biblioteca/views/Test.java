package co.edu.uniquindio.biblioteca.views;

import java.util.ArrayList;

import co.edu.uniquindio.biblioteca.model.Biblioteca;
import co.edu.uniquindio.biblioteca.model.Estudiante;

public class Test {

	public static void main(String[] args) {

		String nombre = "Juan";
		String apellidos = "arias muñoz";
		String resultado = "";
		
		Biblioteca biblioteca = new Biblioteca("Mi biblioteca","calle 12","1234567");
		
		
		try {
			resultado = biblioteca.crearEstudiante(nombre, apellidos, 20, "sistemas", "activo", "12345");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultado = e.getMessage();
		}
		System.out.println(resultado);
		try {
			resultado = biblioteca.crearEstudiante(nombre, apellidos, 20, "sistemas", "activo", "12345");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			resultado = e.getMessage();
		}
		System.out.println(resultado);
		try {
			resultado = biblioteca.crearEstudiante(nombre, apellidos, 20, "sistemas", "activo", "12345");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultado = e.getMessage();
		}
		System.out.println(resultado);
		try {
			resultado = biblioteca.crearEstudiante(nombre, apellidos, 20, "sistemas", "activo", "12345");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultado = e.getMessage();
		}
		System.out.println(resultado);
		


		

	}

}
