package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Escribir un método que genere una matriz de tamaño n de la forma:
 * 
 * 6 6 6 6 6 6<br>
 * 6 5 5 5 5 5<br>
 * 6 5 4 4 4 4<br>
 * 6 5 4 3 3 3<br>
 * 6 5 4 3 2 2<br>
 * 6 5 4 3 2 1
 * 
 * @author amador
 */
public class Punto18 {
	public static void main(String[] args) {
		int[][] matriz = generarMatriz(6);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] generarMatriz(int n) {
		int[][] matriz = new int[n][n];
		generarMatrizAux(matriz, 0);
		return matriz;
	}

	private static void generarMatrizAux(int[][] matriz, int i) {
		if (i < matriz.length) {
			generarMatrizHorizontal(matriz, i, 0);
			generarMatrizVertical(matriz, i, 0);
			generarMatrizAux(matriz, i + 1);
		}
	}

	private static void generarMatrizVertical(int[][] matriz, int i, int j) {
		if (j < matriz.length) {
			matriz[j][matriz.length - 1 - i] = i + 1;
			generarMatrizVertical(matriz, i, j + 1);
		}
	}

	private static void generarMatrizHorizontal(int[][] matriz, int i, int j) {
		if (j < matriz[i].length) {
			matriz[matriz.length - 1 - i][j] = i + 1;
			generarMatrizHorizontal(matriz, i, j + 1);
		}
	}
}
