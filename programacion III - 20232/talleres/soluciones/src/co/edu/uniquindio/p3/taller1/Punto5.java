package co.edu.uniquindio.p3.taller1;

/**
 * Sumar los valores que están debajo de la diagonal secundaria de una matriz de
 * enteros cuadrada.
 * 
 * 
 * @author amador
 *
 */
public class Punto5 {
	public static void main(String[] args) {   
		int[][] matriz = {
	            {4, 2, 7, 1, 9},
	            {6, 0, 3, 8, 5},
	            {1, 4, 9, 2, 6},
	            {8, 5, 2, 7, 3},
	            {3, 6, 0, 4, 1}
		};
		int suma = sumarAbajoDiagonalSecu(matriz);
		System.out.println(suma);
	}

	public static int sumarAbajoDiagonalSecu(int[][] matriz) {
		return sumarAbajoDiagonalSecuAux(matriz, 1, 0, 0);
	}

	public static int sumarAbajoDiagonalSecuAux(int[][] m, int i, int j, int suma) {
		if (i == m.length)
			return suma;
		if (j == m.length)
			return sumarAbajoDiagonalSecuAux(m, i + 1, 0, suma);
		if ((i + j) >= m.length)
			return sumarAbajoDiagonalSecuAux(m, i, j + 1, suma + m[i][j]);
		return sumarAbajoDiagonalSecuAux(m, i, j + 1, suma);
	}

}
