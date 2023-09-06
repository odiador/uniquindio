package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Multiplicar dos matrices (no necesariamente cuadradas).
 * 
 * @author amador
 *
 */
public class Punto17 {
	public static void main(String[] args) throws Exception {
		int[][] m1 = { //
				{ 2, 3, 1 }, //
				{ -1, 2, -8 },//
		};
		int[][] m2 = { //
				{ 1, 1, 3 }, //
				{ 2, -1, 2 }, //
				{ 5, 3, 1 } //
		};
		// 2+6+5
		// 2-3+3
		// 6+6+1

		// -1+4-40
		// -1-2-24
		// -3+4-8

		int[][] matrizResult = multiplicarMatrices(m1, m2);
		for (int i = 0; i < matrizResult.length; i++) {
			for (int j = 0; j < matrizResult[0].length; j++) {
				System.out.print(matrizResult[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] multiplicarMatrices(int[][] m1, int[][] m2) throws Exception {
		if (m1[0].length != m2.length)
			throw new Exception("No se pueden multiplicar");
		int matrizResult[][] = new int[m1.length][m2[0].length];
		multiplicarMatricesAux(m1, m2, matrizResult, 0, 0);
		return matrizResult;
	}

	private static void multiplicarMatricesAux(int[][] m1, int[][] m2, int[][] matrizResult, int i, int j) {
		if (i == matrizResult.length)
			return;
		if (j == matrizResult[0].length) {
			multiplicarMatricesAux(m1, m2, matrizResult, i + 1, 0);
			return;
		}
		matrizResult[i][j] = multiplicarMatricesAux2(m1, m2, i, j, 0, 0);
		multiplicarMatricesAux(m1, m2, matrizResult, i, j + 1);

	}

	private static int multiplicarMatricesAux2(int[][] m1, int[][] m2, int i, int j, int k, int suma) {
		if (k == m2.length)
			return suma;
		return multiplicarMatricesAux2(m1, m2, i, j, k + 1, suma + m1[i][k] * m2[k][j]);
	}

}
