package co.edu.uniquindio.p3.ejercicioaa;

/**
 * Imprimir en consola una matriz cuadrada de cualquier tipo.
 * 
 * @author amador
 *
 */
public class Punto09 {

	public static void imprimirMatriz(int[][] m) {
		System.out.println("[");
		imprmimirMatrizAux(m, 0);
		System.out.println("]");
	}

	public static void imprmimirMatrizAux(int[][] m, int i) {
		if (i >= m.length)
			return;
		Punto05.imprimirArr(m[i]);
		imprmimirMatrizAux(m, i + 1);
	}
	public static void main(String[] args) {
	    int[][] matriz = {
	            {4, 2, 7, 1, 9},
	            {6, 0, 3, 8, 5},
	            {1, 4, 9, 2, 6},
	            {8, 5, 2, 7, 3},
	            {3, 6, 0, 4, 1}
		};
	    imprimirMatriz(matriz);
	}
}
