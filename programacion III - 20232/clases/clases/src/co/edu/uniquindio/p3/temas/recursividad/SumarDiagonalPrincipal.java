package co.edu.uniquindio.p3.temas.recursividad;

public class SumarDiagonalPrincipal {
	public static int sumarDiagonalPrincipal(int[][] matriz) {
		return sumarDiagonalPrincipalAux(matriz, 0);
	}

	private static int sumarDiagonalPrincipalAux(int[][] matriz, int i) {
		if (i == matriz.length)
			return 0;
		return matriz[i][i] + sumarDiagonalPrincipalAux(matriz, i + 1);
	}
	public static void main(String[] args) {
	    int[][] matriz = {
	            {4, 2, 7, 1, 9},
	            {6, 0, 3, 8, 5},
	            {1, 4, 9, 2, 6},
	            {8, 5, 2, 7, 3},
	            {3, 6, 0, 4, 1}
		};
		System.out.println(sumarDiagonalPrincipal(matriz));
	}
}
