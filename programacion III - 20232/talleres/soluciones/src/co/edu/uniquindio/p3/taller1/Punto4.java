package co.edu.uniquindio.p3.taller1;

import java.util.ArrayList;

/**
 * Programe un método para generar la combinación de los elementos de un arreglo
 * de cadenas. Ejemplo, si entra A, B, C, D, E, F, la salida es: AB, AC, AD, AE,
 * AF, BC, BD, BE, BF, CD, CE, CF, DE, DF, EF. Guarde la solución en un
 * ArrayList.
 * 
 * 
 * 
 * @author amador
 *
 */
public class Punto4 {
	public static void main(String[] args) {
		String[] a = { "A", "B", "C", "D", "E", "F" };
		ArrayList<String> suma = obtenerCombinaciones(a);
		System.out.println(suma);
	}

	public static ArrayList<String> obtenerCombinaciones(String[] a) {
		ArrayList<String> lista = new ArrayList<>();
		return obtenerCombinacionesAux(a, lista, 0, 1);
	}

	public static ArrayList<String> obtenerCombinacionesAux(String[] a, ArrayList<String> lista, int i, int j) {
		if (i == a.length)
			return lista;
		if (j == a.length)
			return obtenerCombinacionesAux(a, lista, i + 1, i + 2);
		lista.add(a[i] + a[j]);
		return obtenerCombinacionesAux(a, lista, i, j + 1);
	}

}
