package co.edu.uniquindio.p3.tallerrepaso1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Ordenar un array de forma descendente.
 * 
 * @author amador
 *
 */
public class Punto02 {
	public static void main(String[] args) {
		final int[] numeros = { 4, 7, 2, 10, 1, 9, 5, 8, 3, 6 };
		ordenarArr(numeros, (i, j) -> j - i);
		System.out.println(Arrays.toString(numeros));
	}

	public static void ordenarArr(final int[] numeros, final Comparator<Integer> condicion) {
		ordenarArrDescendenteAux(numeros, 0, 1, condicion);
	}

	public static void ordenarArrDescendente(final int[] numeros) {
		ordenarArrDescendenteAux(numeros, 0, 1, (i, j) -> j - i);
	}

	public static void ordenarArrAscendente(final int[] numeros) {
		ordenarArrDescendenteAux(numeros, 0, 1, (i, j) -> i - j);
	}

	public static void ordenarArrDescendenteAux(final int[] numeros, final int i, final int j,
			final Comparator<Integer> condicionIntercambio) {
		if (j == numeros.length && i == numeros.length - 1)
			return;
		if (j == numeros.length) {
			ordenarArrDescendenteAux(numeros, i + 1, i + 2, condicionIntercambio);
			return;
		}
		if (condicionIntercambio.compare(numeros[i], numeros[j]) > 0) {
			final int aux = numeros[j];
			numeros[j] = numeros[i];
			numeros[i] = aux;
		}
		ordenarArrDescendenteAux(numeros, i, j + 1, condicionIntercambio);
	}
}
