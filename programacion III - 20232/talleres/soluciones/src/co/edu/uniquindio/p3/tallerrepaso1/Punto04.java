package co.edu.uniquindio.p3.tallerrepaso1;

import static java.lang.Math.sqrt;

/**
 * Escriba un método que retorne la norma de un vector (a) de tamaño n. La norma
 * de un vector se calcula sacando la raíz cuadrada a la sumatoria de cada uno
 * de sus elementos al cuadrado.
 * 
 * @author amador
 *
 */
public class Punto04 {
	public static void main(String[] args) {
		int[] numeros = { 4, 7, 2, 10 };
		// 16 + 49 + 4 + 100 = 169
		double norma = obtenerNormaVector(numeros);
		System.out.println(norma);
	}

	public static double obtenerNormaVector(int[] numeros) {
		return sqrt(obtenerNormaVectorAux(numeros, 0));
	}

	private static int obtenerNormaVectorAux(int[] numeros, int i) {
		if (i == numeros.length)
			return 0;
		return numeros[i] * numeros[i] + obtenerNormaVectorAux(numeros, i + 1);
	}
}
