package co.edu.uniquindio.p3.ejercicioaa;

import java.util.Random;

/**
 * Contar cuántas veces está un elemento dentro de un array.
 * 
 * @author amador
 *
 */
public class Punto08 {

	public static int obtenerFrecuencia(int a[], int num) {
		return obtenerFrecuenciaAux(a, 0, num);
	}

	private static int obtenerFrecuenciaAux(int[] a, int i, int num) {
		if (i >= a.length)
			return 0;
		return (a[i] == num ? 1 : 0) + obtenerFrecuenciaAux(a, i + 1, num);
	}

	public static int obtenerFrecuencia2(int a[], int num) {
		return obtenerFrecuenciaAux2(a, 0, num, 0);
	}

	private static int obtenerFrecuenciaAux2(int[] a, int i, int num, int suma) {
		if (i >= a.length)
			return suma;
		return obtenerFrecuenciaAux2(a, i + 1, num, a[i] == num ? suma + 1 : suma);
	}

	public static void main(String[] args) {
		int a[] = new int[10];

		Random ran = new Random();
		for (int i = 0; i < a.length; i++)
			a[i] = ran.nextInt(0, 5);
		Punto05.imprimirArr(a);
		System.out.println(obtenerFrecuencia2(a, 3));
	}
}
