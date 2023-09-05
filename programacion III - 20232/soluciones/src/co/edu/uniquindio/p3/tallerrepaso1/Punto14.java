package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Sumar todos los bordes de una matriz no cuadrada.
 * 
 * @author amador
 *
 */
public class Punto14 {
	public static void main(String[] args) {
		int[][] matriz = { { 9, 4, 15 }, // 28
				{ 7, 11, 2 }, // 9 = 37
				{ 3, 8, 13 }, // 16 = 53
				{ 3, 8, 13 }, // 16 = 69
				{ 3, 8, 13 }, // 16 = 85
				{ 5, 1, 10 }, // 15 = 100
				{ 6, 12, 14 } // 32 = 132
		};
		int bordes = sumarBordesMatriz(matriz);
		System.out.println(bordes);
	}

	private static int sumarBordesMatriz(int[][] matriz) {
		return sumarBordesMatrizAux(matriz, 0, true, 0);
	}

	private static int sumarBordesMatrizAux(int[][] matriz, int i, boolean horizontal, int suma) {
		if (horizontal && i == matriz[0].length)
			return sumarBordesMatrizAux(matriz, 1, false, suma);
		if (!horizontal && i == matriz.length - 1)
			return suma;
		if (horizontal)
			return sumarBordesMatrizAux(matriz, i + 1, horizontal, suma + matriz[0][i] + matriz[matriz.length - 1][i]);

		return sumarBordesMatrizAux(matriz, i + 1, false, suma + matriz[i][0] + matriz[i][matriz[0].length - 1]);
	}
}
