package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Sumar los valores de la diagonal secundaria de una matriz de double.
 * 
 * @author amador
 *
 */
public class Punto12 {
	public static void main(String[] args) {
		double[][] matriz = { 
				{ 4.0, 7.0, 2.0, 5.0 }, 
				{ 1.0, 9.0, 5.0, 8.0 }, 
				{ 1.0, 9.0, 5.0, 8.0 }, 
				{ 3.0, 6.0, 1.3, 2.9 } };
		double suma = sumarMatriz(matriz);
		System.out.println(suma);
	}

	private static double sumarMatriz(double[][] matriz) {
		return sumarMatrizAux(matriz, 0, 0);
	}

	private static double sumarMatrizAux(double[][] matriz, int i, double suma) {
		if (i >= matriz.length)
			return suma;
		return sumarMatrizAux(matriz, i + 1, suma + matriz[i][matriz.length - 1 - i]);
	}
}
