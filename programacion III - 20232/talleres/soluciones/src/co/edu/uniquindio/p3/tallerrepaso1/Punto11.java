package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Buscar el número menor en una matriz cuadrada de números enteros dada.
 * 
 * @author amador
 *
 */
public class Punto11 {
	public static void main(String[] args) {
		int matriz[][] = { 
				{ 5, 6, 200, 10 }, 
				{ 0, 5, 7, 8 }, 
				{ -1, -200, 7, 1 }, 
				{ -100, -20, 7, 3 } 
		};
		int menor = obtenerMenor(matriz);
		System.out.println(menor);
	}

	private static int obtenerMenor(int[][] matriz) {
		return obtenerMenorAux(matriz, 0, 0, matriz[0][0]);
	}

	private static int obtenerMenorAux(int[][] matriz, int i, int j, int menor) {
		if (i == matriz.length)
			return menor;
		if (j >= matriz.length)
			return obtenerMenorAux(matriz, i + 1, 0, menor);
		return obtenerMenorAux(matriz, i, j + 1, matriz[i][j] < menor ? matriz[i][j] : menor);
	}
}