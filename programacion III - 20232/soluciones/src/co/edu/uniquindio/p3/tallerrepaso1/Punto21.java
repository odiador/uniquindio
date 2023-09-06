package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Llenar una matriz cuadrada recorriendo la en forma de serpiente.
 * 
 * @author amador
 *
 */
public class Punto21 {
	public static void main(String[] args) {
		int[][] matriz = new int[5][5];
		llenarMatrizSerpiente(matriz);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void llenarMatrizSerpiente(int[][] matriz) {
		llenarMatrizSerpienteAux(matriz, 0, 0, 0);
	}

	private static void llenarMatrizSerpienteAux(int[][] matriz, int i, int j, int x) {
		if (i == matriz.length)
			return;
		if (i % 2 == 0) {
			if (j < matriz.length) {
				matriz[i][j] = x;
				llenarMatrizSerpienteAux(matriz, i, j + 1, x + 1);
			} else {
				llenarMatrizSerpienteAux(matriz, i + 1, j - 1, x);
			}
		} else {
			if (j >= 0) {
				matriz[i][j] = x;
				llenarMatrizSerpienteAux(matriz, i, j - 1, x + 1);
			} else {
				llenarMatrizSerpienteAux(matriz, i + 1, j + 1, x);
			}
		}
	}
}
