package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Determinar si una matriz es o no simétrica (es cuadrada y sus elementos por
 * encima de la diagonal son iguales a los elementos de por debajo en forma de
 * espejo).
 * 
 * @author amador
 *
 */
public class Punto20 {
	public static void main(String[] args) {
		int[][] matriz = { //
				{ 17, 4, 8, 3 }, //
				{ 4, 12, 5, 6 }, //
				{ 8, 5, 14, 7 }, //
				{ 3, 6, 70, 9 }//
		};
		boolean esSimetrica = esSimetrica(matriz);
		System.out.println(esSimetrica);
	}

	private static boolean esSimetrica(int[][] matriz) {
		return matriz.length == matriz[0].length && esSimetricaAux(matriz, 0, 0);
	}

	private static boolean esSimetricaAux(int[][] matriz, int i, int j) {
		if (i == matriz.length)
			return true;
		if (j == matriz.length)
			return esSimetricaAux(matriz, i + 1, 0);
		return matriz[i][j] == matriz[j][i] && esSimetricaAux(matriz, i, j + 1);
	}
}
