package co.edu.uniquindio.p3.ejercicioaa;

import java.util.Random;

/**
 * Devolver el menor elemento de un arreglo.
 * 
 * @author amador
 *
 */
public class Punto07 {

	/**
	 * Obtiene el numero menor en un arreglo de enteros, es usado por
	 * {@link A_Arreglos#obtenerMenor(int[])}
	 * 
	 * @param a
	 * @param i
	 * @param min
	 * @return
	 */
	public static int obtenerMenorAux(int a[], int i, int min) {
		if (i < a.length)
			return obtenerMenorAux(a, i + 1, a[i] < min ? a[i] : min);
		return min;
	}

	public static int obtenerMenor(int a[]) {
		return obtenerMenorAux(a, 1, a[0]);
	}

	public static void main(String[] args) {
		int a[] = new int[10];

		Random ran = new Random();
		for (int i = 0; i < a.length; i++)
			a[i] = ran.nextInt(0, 20);
		Punto05.imprimirArr(a);
		System.out.println(obtenerMenor(a));
	}
}
