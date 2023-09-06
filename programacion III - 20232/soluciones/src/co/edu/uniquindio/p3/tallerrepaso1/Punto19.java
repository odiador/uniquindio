package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Sumar todos los elementos de las columnas impares de una matriz.
 * 
 * @author amador
 *
 */
public class Punto19 {
	public static void main(String[] args) {
		int[][] matriz = { //
				{ 17, 23, 8, 15 }, //
				{ 4, 12, 19, 6 }, //
				{ 10, 5, 14, 21 }, //
				{ 3, 11, 7, 9 }//
		};
		// 23 + 12 + 5 + 11 = 51 
		// 15 + 6 + 21 + 9 = 51 
		int suma = sumarImpares(matriz);
		System.out.println(suma);
	}

	private static int sumarImpares(int[][] matriz) {
		return sumarImparesAux(matriz, 0, 1);
	}

	private static int sumarImparesAux(int[][] matriz, int i, int j) {
		if (j >= matriz[0].length)
			return 0;
		if (i >= matriz.length)
			return sumarImparesAux(matriz, 0, j + 2);
		return matriz[i][j] + sumarImparesAux(matriz, i + 1, j);
	}
}
