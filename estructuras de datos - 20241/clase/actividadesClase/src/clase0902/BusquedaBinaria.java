package clase0902;

import java.util.Arrays;

public class BusquedaBinaria {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int result = Arrays.binarySearch(arr, 100);
		System.out.println(result);
	}

	/**
	 * {@link Arrays#binarySearch(int[], int)} c
	 */
	public static int binarySearch(int[] a, int key) {
		return binarySearch0(a, 0, a.length, key);
	}

	// usa el metodo de divide y venceras para hacer la busqueda
	private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			// suma menor y mayor y divide entre 2 el >>> 1 mueve un bit a la derecha, que
			// hace que por ejemplo con el numero 8 (1000) al moverse a la derecha se
			// convierte en un (0100) o un 4
			int midVal = a[mid];

			// si el valor de la mitad es menor que el que se busca, se mueve el indice para
			// encontrar un rango mas cercano
			if (midVal < key)
				low = mid + 1;
			// en caso de que sea mayor, se cambia el indice mas alto
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

}
