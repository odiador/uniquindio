package clase7;

import esen.*;

public class diagonalnxn {
	public static int[][] generarMatriz2D(int filas, int columnas, String mensaje){
		int matriz2D[][] = new int [filas][columnas];
		for (int i = 0;i<filas;i++) {
			for (int j = 0;j<columnas;j++) {
				if(i==j) matriz2D[i][j] = 1;
				if(i<j) matriz2D[i][j] = 0;
				if(i>j) matriz2D[i][j] = 2;
			}
		}
		return matriz2D;
	}

	public static void main(String[] args) {
		int f = cial.leerInt("Ingrese la cantidad de filas de la matriz");
		int c = cial.leerInt("Ingrese la cantidad de columnas de la matriz");
		int matriz2D[][] = generarMatriz2D(f,c,"Ingrese un numero");
		String msg = cial.deMatrizIntAString(matriz2D);
		cial.imprimir(msg);
	}
}
