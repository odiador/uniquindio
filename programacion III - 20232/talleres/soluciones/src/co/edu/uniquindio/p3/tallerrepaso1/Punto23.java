package co.edu.uniquindio.p3.tallerrepaso1;

import java.util.Arrays;

/**
 * La búsqueda binaria implica que un array esté ordenado, y el algoritmo
 * consiste en dividir el array por su elemento medio en dos subarrays más
 * pequeños, y comparar el elemento con el del centro. Si coinciden, la búsqueda
 * se termina. Si el elemento es menor, debe estar (si está) en el primer
 * subarray, y si es mayor está en el segundo. Escriba un método de búsqueda
 * binaria.
 * 
 * @author amador
 *
 */
public class Punto23 {
	public static void main(String[] args) throws Exception {
		int[] numeros2 = { 13, 311, 675, 879, 1044 };
		int binaria = busquedaBinaria(numeros2, 672);
		System.out.println(binaria);
	}

	private static int busquedaBinaria(int[] numeros, int n) throws Exception {
		if (!estaOrdenado(numeros, 0))
			throw new Exception("El arreglo no esta ordenado");
		return busquedaBinaria(numeros, n, 0, numeros.length);
	}

	private static int busquedaBinaria(int[] numeros, int n, int i, int length) {
		if (i > length)
			return -(i + 1);
		if (numeros[(i + length) / 2] == n)
			return (i + length) / 2;
		if (numeros[(i + length) / 2] > n) {
			return busquedaBinaria(numeros, n, i, ((i + length) / 2) - 1);
		}
		return busquedaBinaria(numeros, n, ((i + length) / 2) + 1, length);

	}

	private static boolean estaOrdenado(int[] numeros, int i) {
		if (i == numeros.length - 2)
			return numeros[i] < numeros[i + 1];
		if (numeros[i] > numeros[i + 1])
			return false;
		return estaOrdenado(numeros, i + 1);
	}
}
