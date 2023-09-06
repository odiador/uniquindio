package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Generar una matriz de la siguiente manera:<br>
 * 0 0 0 0 0 1<br>
 * 0 0 0 0 1 2<br>
 * 0 0 0 1 2 3<br>
 * 0 0 1 2 3 4<br>
 * 0 1 2 3 4 5<br>
 * 1 2 3 4 5 6
 * 
 * @author amador
 */
public class Punto16 {
	/**
	 */
	public static void main(String[] args) {
		int[][] matriz = new int[6][6];
		llenarMatriz(matriz);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void llenarMatriz(int[][] matriz) {
		llenarMatriz(matriz, matriz.length - 1);
	}

	private static void llenarMatriz(int[][] matriz, int i) {
		if (i >= 0) {
			llenarMatrizAux(matriz, i, matriz.length - 1 - i, 1);
			llenarMatriz(matriz, i - 1);
		}
	}

	private static void llenarMatrizAux(int[][] matriz, int i, int j, int num) {
		if (j < matriz.length) {
			matriz[i][j] = num;
			llenarMatrizAux(matriz, i, j + 1, num + 1);
		}

	}
}
