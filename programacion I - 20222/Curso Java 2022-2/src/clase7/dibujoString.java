package clase7;

import esen.*;

public class dibujoString {
	public static String[][] generarMatriz2D(String cadena){
		int n = cadena.length();
		String matriz2D[][] = new String [n][n];
		for (int i = 0;i<n;i++) {
			for (int j = 0;j<n;j++) {
				if (i>=j) matriz2D[i][j] = cadena.charAt(j)+"";
				if (i<j) matriz2D[i][j] = "*";

			}
		}
		return matriz2D;
	}

	public static void main(String[] args) {
		String cadena = cial.leerString("Ingrese la cadena");
		String matriz2D[][] = generarMatriz2D(cadena);
		String msg = cial.deMatrizStringAString(matriz2D);
		cial.imprimir(msg);
	}
}
