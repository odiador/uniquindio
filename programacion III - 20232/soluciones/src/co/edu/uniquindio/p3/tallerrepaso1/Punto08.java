package co.edu.uniquindio.p3.tallerrepaso1;

import java.util.Arrays;

/**
 * Buscar en un arreglo de cadenas cuales de ellas tiene como letra del medio la
 * “e”.
 * 
 * @author amador
 *
 */
public class Punto08 {
	public static void main(String[] args) {
		String[] arr = { "Pepe", "Peppa", "Peeea", "Pinea", "HoeaH" };
		String[] cadenasMitadE = obtenerCadenasMitadE(arr);
		System.out.println(Arrays.toString(cadenasMitadE));
	}

	public static String[] obtenerCadenasMitadE(String[] arr) {

		return obtenerCadenasMitadEAux(arr, 0, "").split("-");
	}

	public static String obtenerCadenasMitadEAux(String[] arr, int i, String cad) {
		if (i == arr.length)
			return cad;
		if (arr[i].charAt(arr[i].length() / 2) == 'e')
			cad += arr[i] + "-";
		return obtenerCadenasMitadEAux(arr, i + 1, cad);
	}
}
