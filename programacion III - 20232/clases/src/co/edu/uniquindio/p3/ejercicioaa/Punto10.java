package co.edu.uniquindio.p3.ejercicioaa;

/**
 * Sumar todos los elementos de una matriz cuadrada.
 * 
 * @author amador
 *
 */
public class Punto10 {
	public static int sumarElementos(int[][] m) {
		return sumarElementosAux(m, 0);
	}

	private static int sumarElementosAux(int[][] m, int i) {
		if (i >= m.length)
			return 0;
		return sumarElementosAuxJ(m, i, 0) + sumarElementosAux(m, i + 1);
	}

	private static int sumarElementosAuxJ(int[][] m, int i, int j) {
		if (j >= m[i].length)
			return 0;
		return m[i][j] + sumarElementosAuxJ(m, i, j + 1);
	}
	public static void main(String[] args) {
	   int[][] matriz = {
	            {4, 2, 7, 1, 9},
	            {6, 0, 3, 8, 5},
	            {1, 4, 9, 2, 6},
	            {8, 5, 2, 7, 3},
	            {3, 6, 0, 4, 1}
		};
		System.out.println(sumarElementos(matriz));
	}
}
