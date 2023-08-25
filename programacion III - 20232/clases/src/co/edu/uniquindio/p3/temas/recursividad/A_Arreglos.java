package co.edu.uniquindio.p3.temas.recursividad;

import java.util.Random;

public class A_Arreglos {
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

	public static void imprimirArr(int a[]) {
		String msg = "{";
		System.out.println(imprimirArrAux(a, 0, msg));
	}

	private static String imprimirArrAux(int[] a, int i, String msg) {
		if (i >= a.length)
			return msg + "}";
		if (i == a.length - 1)
			return imprimirArrAux(a, i + 1, msg + a[i]);
		return imprimirArrAux(a, i + 1, msg + a[i] + ", ");
	}

	public static void main(String[] args) {
		int a[] = new int[10];
		
		Random ran = new Random();
		for (int i = 0; i < a.length; i++)
			a[i] = ran.nextInt(0, 20);
		imprimirArr(a);
		System.out.println(obtenerMenor(a));
	}
}
