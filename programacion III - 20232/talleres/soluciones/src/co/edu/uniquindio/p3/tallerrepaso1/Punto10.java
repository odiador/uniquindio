package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Hallar el promedio de los elementos de la diagonal de una matriz cuadrada.
 * 
 * @author amador
 *
 */
public class Punto10 {
	public static void main(String[] args) {
		int matriz[][] = {
				{ 5, 6, 200, 10 }, 
				{ 0, 5, 7, 8 }, 
				{ -1, 20, 7, 1 }, 
				{ -100, -20, 7, 3 }
				};
		double promDiagonal = obtenerPromedioDiagonal(matriz);
		System.out.println(promDiagonal);
	}

	private static double obtenerPromedioDiagonal(int[][] matriz) {
		return obtenerPromedioDiagonalAux(matriz, 0, 0);
	}

	private static double obtenerPromedioDiagonalAux(int[][] matriz, int i, int sum) {
		if (i == matriz.length)
			return sum / matriz.length;
		return obtenerPromedioDiagonalAux(matriz, i + 1, sum + matriz[i][i]);
	}
}
