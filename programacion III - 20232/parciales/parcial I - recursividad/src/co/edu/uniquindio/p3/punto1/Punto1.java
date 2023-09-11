package co.edu.uniquindio.p3.punto1;

import java.util.Arrays;

/**
 * Haga una prueba de escritorio al siguiente código:
 *
 */
public class Punto1 {
	public static void main(String[] args) {
		int arr[] = { 7, 2, 1, 6, 8, 5, 3, 4 };
		metodo1(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void metodo1(int[] arr, int a, int b) {
		if (a < b) {
			int p = metodo2(arr, a, b);

			metodo1(arr, a, p - 1);
			metodo1(arr, p + 1, b);
		}

	}

	private static int metodo2(int[] arr, int a, int b) {
		int p = arr[b];
		int i = a - 1;
		for (int j = a; j < b; j++) {
			if (arr[j] <= p) {
				i++;
				int aux = arr[i];
				arr[i] = arr[j];
				arr[j] = aux;
			}
		}
		int aux = arr[i + 1];
		arr[i + 1] = arr[b];
		arr[b] = aux;
		return i + 1;
	}
}
