package co.edu.uniquindio.p3.ejercicioaa;

import java.util.Random;

/**
 * Sumar todos los elementos de un array.
 * 
 * @author amador
 *
 */
public class Punto06 {

	public static int sumarElementosArr(int a[]) {
		return sumarElementosArrAux(a, 0);
	}

	private static int sumarElementosArrAux(int[] a, int i) {
		if (i >= a.length)
			return 0;
		return a[i] + sumarElementosArrAux(a, i + 1);
	}

	public static void main(String[] args) {
		int a[] = new int[10];

		Random ran = new Random();
		for (int i = 0; i < a.length; i++)
			a[i] = ran.nextInt(0, 5);
		Punto05.imprimirArr(a);
		System.out.println(sumarElementosArr(a));
	}
}
