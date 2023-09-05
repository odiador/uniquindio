package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Realizar la suma de 2 matrices cuadradas de los mismos tamaños.
 * 
 * @author amador
 */
public class Punto15 {
	public static void main(String[] args) {
		int[][] matriz1 = { 
				{ 8, 3, 12, 7 }, 
				{ 1, 6, 9, 2 }, 
				{ 11, 5, 4, 10 }, 
				{ 13, 15, 14, 16 } 
				};
		int[][] matriz2 = { 
				{ 17, 23, 8, 15 }, 
				{ 4, 12, 19, 6 }, 
				{ 10, 5, 14, 21 }, 
				{ 3, 11, 7, 9 } 
				};
		int[][] matrizSuma = obtenerSumaMatrices(matriz1, matriz2);
		for (int i = 0; i < matrizSuma.length; i++) {
			for (int j = 0; j < matrizSuma[i].length; j++) {
				System.out.print(matrizSuma[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static int[][] obtenerSumaMatrices(int[][] matriz1, int[][] matriz2) {
		int[][] matrizCopia = new int[matriz1.length][matriz1.length];
		sumarMatrices(matriz1, matriz2, 0, 0, matrizCopia);
		return matrizCopia;
	}

	private static void sumarMatrices(int[][] matriz1, int[][] matriz2, int i, int j, int[][] matrizCopia) {
		if (i < matrizCopia.length) {
			if (j < matrizCopia.length) {
				matrizCopia[i][j] = matriz1[i][j] + matriz2[i][j];
				sumarMatrices(matriz1, matriz2, i, j + 1, matrizCopia);
			} else {
				sumarMatrices(matriz1, matriz2, i + 1, 0, matrizCopia);
			}
		}
	}
}
